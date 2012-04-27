package edu.upenn.cis350;

import java.io.IOException;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MusicList extends ListActivity {
	private int lastClicked;
	private MediaPlayer mp;
	
	// ugly hardcoded thing for now
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  lastClicked = -1;
	  mp = null;
	  
	  final String[] NAMES = new String[] {"Manley Stacey", "Cornelia Hancock", "Johnny Comes Marching Home", "Audio 4"};
	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, NAMES));

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);
	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	    	// if the button clicked is the same as the previous button clicked, stop playing
	    	if (position == lastClicked) {
	    		if (mp != null && mp.isPlaying()) {
		    	    mp.release();
	    			try {
						mp.prepare();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    	}
	    	else if(position == 0) {
	    		managePlayer(R.raw.a2);
	    	}
	    	else if (position == 1) {
	    		managePlayer(R.raw.a1);
	    	}
	    	else if (position == 2) {
	    		managePlayer(R.raw.johnnycomesmarchinghome);
	    	}
	    	lastClicked = position;
	    }
	  });
	}
	
	private void managePlayer(int resourceId) {
		// stop previous file from playing
		if (mp != null) {
			mp.release();
		}
		
		// make a new player for the resource
	    mp = MediaPlayer.create(MusicList.this, resourceId);
	    
	    //toggle the player on or off
	    mp.seekTo(0);
		if (mp.isPlaying()) {
	    	mp.stop();
		}
		else {
			mp.start();
		}
	}
	
	@Override
	public void onBackPressed() {
		if (mp != null) {
			mp.release();
		}
		finish();
		return;
	}
}
