package edu.upenn.cis350;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 
public class AudioPlayer extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Log.v("Status:", "entered activity");
        super.onCreate(savedInstanceState);
        Log.v("Status:", "Super'd");
        setContentView(R.layout.audioplayerlayout);
        Log.v("Status:", "set content view");
       
        /*Button cmd_play = (Button)this.findViewById(R.id.play_button);
        cmd_play.setOnClickListener(new OnClickListener(){
        
           	@Override
            public void onClick(View arg0) {
            	try {
            		Log.v("Status:", "Playing that funky music, white boy");
                    MediaPlayer mp = MediaPlayer.create(AudioPlayer.this, R.raw.a1);
                    Log.v("Status:", "Media loaded");
                    //mp.prepare();
                    //mp.start();
                    
                    
                    
                    try {
                        mp.prepare();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                    Log.v("Status:", "Can you hear me now?");
                    
                    mp.start();
                    
                    
                    mp.setOnCompletionListener(new OnCompletionListener(){
                        public void onCompletion(MediaPlayer arg0) {
                            
                        }
                });
                    
            	}
            	catch (Exception e) {
                	Log.e("err", "error: " + e.getMessage(), e);
                }
            }
        });*/
    }
    
    public void onCloseClick(View view){
		finish();
	}
}
