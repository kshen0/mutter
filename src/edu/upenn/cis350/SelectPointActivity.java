package edu.upenn.cis350;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SelectPointActivity extends Activity {
	
	MediaPlayer mp;
    MediaPlayer mp2;
    
    int l = 0;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.pointselectedlayout);
        
        Bundle b = getIntent().getExtras();
        l = b.getInt("layout");
        setContentView(l);
        
        if (l == R.layout.point3layout) {
        	mp = MediaPlayer.create(SelectPointActivity.this, R.raw.a2);
        	
        	Button cmd_play1 = (Button)this.findViewById(R.id.audio_button);
	        cmd_play1.setOnClickListener(new OnClickListener(){
	        
	           	@Override
	            public void onClick(View arg0) {
	            	try {
	                    Log.v("Status:", "Can you hear me now?");
	                    
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
        }
        
        if (l == R.layout.pointselectedlayout) {
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
        }
        
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
        	    	Toast toast = Toast.makeText(getApplicationContext(), "He's hit your thighbone, time for the saw", Toast.LENGTH_LONG);
        	    	toast.show();
        	    }
        	}.start();
        	
        	new CountDownTimer(30000, 1000) {
        		public void onTick(long millisUntilFinished) {
        	        
        	    }

        	    public void onFinish() {
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
	
	public void onCloseClick(View view){
		if (l == R.layout.pointselectedlayout || l == R.layout.point3layout) {
			if (mp.isPlaying()) {
				mp.stop();
			}
		if (l == R.layout.pointselectedlayout)
			if (mp2.isPlaying()) {
				mp2.stop();
			}
		}
		finish();
	}

}
