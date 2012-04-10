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

	MediaPlayer mp;  //Cornelia
	MediaPlayer mp2;   //manley stacy

	int l = 0;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.pointselectedlayout);
        
        Bundle b = getIntent().getExtras();
        l = b.getInt("layout");
        setContentView(l);
        
        mp = MediaPlayer.create(SelectPointActivity.this, R.raw.a1); //Cornelia
    	mp2 = MediaPlayer.create(SelectPointActivity.this, R.raw.a2);  //manley stacy
	}
	
	// This is called when the Manley Stacy letter button is clicked.  There are two global media players-- mp and mp2.
	// Mp2 corresponds to the Manley Stacy letter.
	public void onClickManleyStacy(View view){
		try {
            Log.v("Status:", "Can you hear me now?");
            
            if (mp.isPlaying()) {  //Check if mp is currenty playing.  If it is, stop it.
            	mp.seekTo(0);
            	mp.stop();
            	mp.prepare();
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
            if (!mp.isPlaying()) {
            	mp.seekTo(0);
            	mp.start();
            }
            else if (mp.isPlaying()) {
            	mp.seekTo(0);
            	mp.stop();
            	mp.prepare();
            }
            
            
            mp.setOnCompletionListener(new OnCompletionListener(){
                public void onCompletion(MediaPlayer arg0) {
                    
                }
            });
            
    	}
    	catch (Exception e) {
        	Log.e("err", "error: " + e.getMessage(), e);
        }
    
	}

	public void onCloseClick(View view) {
		//if (l == R.layout.pointselectedlayout || l == R.layout.point3layout) {
			if (mp.isPlaying()) {
				mp.stop();
			}
			//if (l == R.layout.pointselectedlayout)
				if (mp2.isPlaying()) {
					mp2.stop();
				}
		//}
		finish();
	}

}
