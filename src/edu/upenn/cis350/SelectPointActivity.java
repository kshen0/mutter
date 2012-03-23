package edu.upenn.cis350;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SelectPointActivity extends Activity {
	
	MediaPlayer mp;
    MediaPlayer mp2;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.pointselectedlayout);
        
        mp = MediaPlayer.create(SelectPointActivity.this, R.raw.a1);
        mp2 = MediaPlayer.create(SelectPointActivity.this, R.raw.a2);
        
        //AUDIO 1 button
        Button cmd_play1 = (Button)this.findViewById(R.id.audio_button);
        cmd_play1.setOnClickListener(new OnClickListener(){
        
           	@Override
            public void onClick(View arg0) {
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
        });
        
        //AUDIO 2 BUTTON
        Button cmd_play = (Button)this.findViewById(R.id.audio_button2);
        cmd_play.setOnClickListener(new OnClickListener(){
        	@Override
            public void onClick(View arg0) {
            	try {
            		Log.v("Status:", "Playing that funky music, white boy");
                    //MediaPlayer mp = MediaPlayer.create(SelectPointActivity.this, R.raw.a2);
                    Log.v("Status:", "Media loaded");
                    
                    Log.v("Status:", "Can you hear me now?");
                    
                    if (mp.isPlaying()) {
                    	mp.seekTo(0);
                    	mp.stop();
                    	mp.prepare();
                    }
                    if (!mp2.isPlaying()) {
                    	mp2.seekTo(0);
                    	mp2.start();
                    }
                    else if (mp2.isPlaying()) {
                    	mp2.seekTo(0);
                    	mp2.stop();
                    	mp2.prepare();
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
        });
=======
        Bundle b = getIntent().getExtras();
        setContentView(b.getInt("layout"));
>>>>>>> 9fc8705d74cbce0a048da5a547c5ace81a5d7e0a
	}
	
	public void onCloseClick(View view){
		if (mp.isPlaying()) {
			mp.stop();
		}
		if (mp2.isPlaying()) {
			mp2.stop();
		}
		finish();
	}

}
