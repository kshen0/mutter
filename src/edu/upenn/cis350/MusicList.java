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
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  final String[] NAMES = new String[] {"Manley Stacey", "Cornelia Hancock", "Audio 3", "Audio 4"};
	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, NAMES));

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);
	  //OnItemClickListener foo = new OnItemClickListener();
	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	    	MediaPlayer mp = null;
	    	MediaPlayer mp2 = null;
	    	if(position == 0) {
	    	    mp2 = MediaPlayer.create(MusicList.this, R.raw.a2);  //manley stacy
	    	}
	    	else if (position == 1) {
	    		mp = MediaPlayer.create(MusicList.this, R.raw.a1); //Cornelia
	    	}
	    	if (mp != null && mp.isPlaying()) {  //Check if mp is currenty playing.  If it is, stop it.
            	mp.seekTo(0);
            	mp.stop();
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
            if (mp2 != null && !mp2.isPlaying()) {  // If mp2 is not playing, start it.
            	mp2.seekTo(0);
            	mp2.start();
            }
            else if (mp2 != null && mp2.isPlaying()) { // If mp2 is playing, stop it.  
            	mp2.seekTo(0);
            	mp2.stop();
            	try {
					mp2.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            if(mp2 != null) {
            mp2.setOnCompletionListener(new OnCompletionListener(){
                public void onCompletion(MediaPlayer arg0) {
                    
                }
            }); 
            }
	      // When clicked, show a toast with the TextView text
	      //Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
	        //  Toast.LENGTH_SHORT).show();
	      
	    }
	  });
	}
	
}
