package edu.upenn.cis350;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SelectPointActivity extends Activity {

	MediaPlayer[] audios;
	MediaPlayer cornelia; // Cornelia
	MediaPlayer cornelia2; // Cornelia
	MediaPlayer manley; // manley stacy

	int l = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.pointselectedlayout);

		Bundle b = getIntent().getExtras();
		if (b != null) {
			l = b.getInt("layout");
			setContentView(l);
		}

		cornelia = MediaPlayer.create(SelectPointActivity.this, R.raw.a1); // Cornelia
		cornelia2 = MediaPlayer.create(SelectPointActivity.this,
				R.raw.hancock_cornelia_2); // Cornelia
		manley = MediaPlayer.create(SelectPointActivity.this, R.raw.a2); // manley
																			// stacy

		audios = new MediaPlayer[3];
		audios[0] = cornelia;
		audios[1] = cornelia2;
		audios[2] = manley;
	}

	public void startPlayer(MediaPlayer mp){
		try{
		for (int i = 0; i < audios.length; i++){
			MediaPlayer player = audios[i];
			if (player.isPlaying() && player != mp){
				player.seekTo(0);
				player.stop();
				player.prepare();
			}
		}
		
		if (!mp.isPlaying()) {  // If manley is not playing, start it.
        	mp.seekTo(0);
        	mp.start();
        }
        else if (mp.isPlaying()) { // If manley is playing, stop it.  
        	mp.seekTo(0);
        	mp.stop();
        	mp.prepare();
        }
        
        mp.setOnCompletionListener(new OnCompletionListener(){
            public void onCompletion(MediaPlayer arg0) {
                //no-op
            }
        }); 
		} catch (Exception e){
			Log.e("err", "error: " + e.getMessage(), e);
			
		}		
	}

	// This is called when the Manley Stacy letter button is clicked. There are
	// two global media players-- mp and manley.
	// manley corresponds to the Manley Stacy letter.
	public void onClickManleyStacy(View view) {
//		try {
//			Log.v("Status:", "Can you hear me now?");
//
//			if (cornelia.isPlaying()) { // Check if mp is currenty playing. If
//										// it is, stop it.
//				cornelia.seekTo(0);
//				cornelia.stop();
//				cornelia.prepare();
//			}
//			if (cornelia2.isPlaying()) {
//				cornelia2.seekTo(0);
//				cornelia2.stop();
//				cornelia2.prepare();
//			}
//
//			if (!manley.isPlaying()) { // If manley is not playing, start it.
//				manley.seekTo(0);
//				manley.start();
//			} else if (manley.isPlaying()) { // If manley is playing, stop it.
//				manley.seekTo(0);
//				manley.stop();
//				manley.prepare();
//			}
//
//			manley.setOnCompletionListener(new OnCompletionListener() {
//				public void onCompletion(MediaPlayer arg0) {
//					// no-op
//				}
//			});
//		} catch (Exception e) {
//			Log.e("err", "error: " + e.getMessage(), e);
//		}
		
		startPlayer(manley);
		
	}

	public void onClickCornelia(View view) {
//		try {
//			Log.v("Status:", "Playing that funky music, white boy");
//			// MediaPlayer mp = MediaPlayer.create(SelectPointActivity.this,
//			// R.raw.a1);
//			Log.v("Status:", "Media loaded");
//			// mp.prepare();
//			// mp.start();
//
//			Log.v("Status:", "Can you hear me now?");
//
//			if (manley.isPlaying()) {
//				manley.seekTo(0);
//				manley.stop();
//				manley.prepare();
//			}
//
//			if (cornelia2.isPlaying()) {
//				cornelia2.seekTo(0);
//				cornelia2.stop();
//				cornelia2.prepare();
//			}
//
//			if (!cornelia.isPlaying()) { // If cornelia is not playing, start
//											// it.
//				cornelia.seekTo(0);
//				cornelia.start();
//			} else if (cornelia.isPlaying()) { // If cornelia is playing, stop
//												// it.
//				cornelia.seekTo(0);
//				cornelia.stop();
//				cornelia.prepare();
//			}
//
//			cornelia.setOnCompletionListener(new OnCompletionListener() {
//				public void onCompletion(MediaPlayer arg0) {
//
//				}
//			});
//
//		} catch (Exception e) {
//			Log.e("err", "error: " + e.getMessage(), e);
//		}
		
		startPlayer(cornelia);
		
	}

	public void onClickCornelia2(View view) {
//		try {
//			Log.v("Status:", "Playing that funky music, white boy");
//			// MediaPlayer mp = MediaPlayer.create(SelectPointActivity.this,
//			// R.raw.a1);
//			Log.v("Status:", "Media loaded");
//			// mp.prepare();
//			// mp.start();
//
//			Log.v("Status:", "Can you hear me now?");
//
//			if (manley.isPlaying()) {
//				manley.seekTo(0);
//				manley.stop();
//				manley.prepare();
//			}
//			if (cornelia.isPlaying()) {
//				cornelia.seekTo(0);
//				cornelia.stop();
//				cornelia.prepare();
//			}
//
//			if (!cornelia2.isPlaying()) { // If cornelia2 is not playing, start
//											// it.
//				cornelia2.seekTo(0);
//				cornelia2.start();
//			} else if (cornelia2.isPlaying()) { // If cornelia2 is playing, stop
//												// it.
//				cornelia2.seekTo(0);
//				cornelia2.stop();
//				cornelia2.prepare();
//			}
//
//			cornelia2.setOnCompletionListener(new OnCompletionListener() {
//				public void onCompletion(MediaPlayer arg0) {
//
//				}
//			});
//
//		} catch (Exception e) {
//			Log.e("err", "error: " + e.getMessage(), e);
//		}
		
		startPlayer(cornelia2);
		
	}

	protected void stopPlayers() {
		Log.v("Hit method", "stopping players");
		Log.v("Hit method", "stopping players2");
		if (cornelia != null && cornelia.isPlaying()) {
			cornelia.stop();
		}
		if (manley != null && manley.isPlaying()) {
			manley.stop();
		}
		if (cornelia2 != null && cornelia2.isPlaying()) {
			cornelia2.stop();
		}
	}

	public void onCloseClick(View view) {
		stopPlayers();
		cornelia.release();
		cornelia2.release();
		manley.release();
		finish();
	}
}
