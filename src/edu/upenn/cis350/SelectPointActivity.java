package edu.upenn.cis350;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SelectPointActivity extends Activity {

	MediaPlayer cornelia;  //Cornelia
	MediaPlayer mp2;   //manley stacy
	boolean showMessage;

	int l = 0;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.pointselectedlayout);
        
        Bundle b = getIntent().getExtras();
        l = b.getInt("layout");
        setContentView(l);
        
        cornelia = MediaPlayer.create(SelectPointActivity.this, R.raw.a1); //Cornelia
    	mp2 = MediaPlayer.create(SelectPointActivity.this, R.raw.a2);  //manley stacy
	}
	
	// This is called when the Manley Stacy letter button is clicked.  There are two global media players-- mp and mp2.
	// Mp2 corresponds to the Manley Stacy letter.
	public void onClickManleyStacy(View view){
		try {
            Log.v("Status:", "Can you hear me now?");
            
            if (cornelia.isPlaying()) {  //Check if mp is currenty playing.  If it is, stop it.
            	cornelia.seekTo(0);
            	cornelia.stop();
            	cornelia.prepare();
            }
            if (!mp2.isPlaying()) {  // If mp2 is not playing, start it.
            	mp2.seekTo(0);
            	mp2.start();
            }
            else if (mp2.isPlaying()) { // If mp2 is playing, stop it.  
            	mp2.seekTo(0);
            	mp2.stop();
            	mp2.prepare();
            }
            mp2.setOnCompletionListener(new OnCompletionListener(){
                public void onCompletion(MediaPlayer arg0) {
                    
                }
            }); 
    	}
    	catch (Exception e) {
        	Log.e("err", "error: " + e.getMessage(), e);
        }
    }
	
	public void onClickCornelia(View view){
		try {
    		Log.v("Status:", "Playing that funky music, white boy");
            //MediaPlayer mp = MediaPlayer.create(SelectPointActivity.this, R.raw.a1);
            Log.v("Status:", "Media loaded");
            //mp.prepare();
            //mp.start();
            
            Log.v("Status:", "Can you hear me now?");
            
            if (mp2.isPlaying()) {
            	mp2.seekTo(0);
            	mp2.stop();
            	mp2.prepare();
            }
            if (!cornelia.isPlaying()) {
            	cornelia.seekTo(0);
            	cornelia.start();
            }
            else if (cornelia.isPlaying()) {
            	cornelia.seekTo(0);
            	cornelia.stop();
            	cornelia.prepare();
            }
            
            
            cornelia.setOnCompletionListener(new OnCompletionListener(){
                public void onCompletion(MediaPlayer arg0) {
                    
                }
            });
            
    	}
    	catch (Exception e) {
        	Log.e("err", "error: " + e.getMessage(), e);
        }
    
	}

	public void onCloseClick(View view) {
		showMessage = false;
		//if (l == R.layout.pointselectedlayout || l == R.layout.point3layout) {
			if (cornelia.isPlaying()) {
				cornelia.stop();
			}
			//if (l == R.layout.pointselectedlayout)
				if (mp2.isPlaying()) {
					mp2.stop();
				}
		//}
		finish();
	}

}
