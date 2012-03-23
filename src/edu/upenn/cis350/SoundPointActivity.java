package edu.upenn.cis350;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


public class SoundPointActivity extends SelectPointActivity { 
	
	private MediaPlayer mediaPlayer;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer.create(this.getBaseContext(), R.raw.hancock_cornelia_1);
        setContentView(R.layout.soundlayout);
	}
	
	public void onCloseClick(View view){
		mediaPlayer.release();
		mediaPlayer = null;
		finish();
	}
}
