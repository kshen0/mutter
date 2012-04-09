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
        
        if (l == R.layout.pointlayouttwo) {
        	new CountDownTimer(3000, 1000) {
        		public void onTick(long millisUntilFinished) {
        	        
        	    }

        	    public void onFinish() {
        	    	Toast toast = Toast.makeText(getApplicationContext(), "You've come to the medic with a wounded leg to be amputated", Toast.LENGTH_LONG);
        	    	toast.show();
        	    }
        	}.start();
        	
        	new CountDownTimer(10000, 1000) {
        		public void onTick(long millisUntilFinished) {
        	        
        	    }

        	    public void onFinish() {
        	    	Toast toast = Toast.makeText(getApplicationContext(), "You take a drink of whiskey", Toast.LENGTH_LONG);
        	    	toast.show();
        	    }
        	}.start();
        	
        	new CountDownTimer(16000, 1000) {
        		public void onTick(long millisUntilFinished) {
        	        
        	    }

        	    public void onFinish() {
        	    	Toast toast = Toast.makeText(getApplicationContext(), "The medic has made his first incision", Toast.LENGTH_LONG);
        	    	toast.show();
        	    }
        	}.start();
        	
        	new CountDownTimer(24000, 1000) {
        		public void onTick(long millisUntilFinished) {
        	        
        	    }

        	    public void onFinish() {
        	    	// Get instance of Vibrator from current Context
        	    	Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        	    	 
        	    	// Vibrate for 300 milliseconds
        	    	v.vibrate(300);

        	    	Toast toast = Toast.makeText(getApplicationContext(), "He's hit your thighbone, time for the saw", Toast.LENGTH_LONG);
        	    	toast.show();
        	    }
        	}.start();
        	
        	new CountDownTimer(30000, 1000) {
        		public void onTick(long millisUntilFinished) {
        	        
        	    }

        	    public void onFinish() {
        	    	// Get instance of Vibrator from current Context
        	    	Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        	    	 
        	    	// Vibrate for 300 milliseconds
        	    	v.vibrate(700);
        	    	Toast toast = Toast.makeText(getApplicationContext(), "Through the bone", Toast.LENGTH_LONG);
        	    	toast.show();
        	    }
        	}.start();
        	
        	new CountDownTimer(40000, 1000) {
        		public void onTick(long millisUntilFinished) {
        	        
        	    }

        	    public void onFinish() {
        	    	Toast toast = Toast.makeText(getApplicationContext(), "Your leg has now been fully removed.", Toast.LENGTH_LONG);
        	    	toast.show();
        	    }
        	}.start();
        }
	}
	
	public void onClickManleyStacy(View view){
		//mp = MediaPlayer.create(SelectPointActivity.this, R.raw.a2);
		try {
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
		
		//mp = MediaPlayer.create(SelectPointActivity.this, R.raw.a1);
        //mp2 = MediaPlayer.create(SelectPointActivity.this, R.raw.a2);
		
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
