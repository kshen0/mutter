package edu.upenn.cis350;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import java.util.HashSet;

public class TimerActivity extends SelectPointActivity {
	HashSet<CountDownTimer> timers;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        timers = new HashSet<CountDownTimer>();
        
        Bundle b = getIntent().getExtras();
		int l = 0;
		l = b.getInt("layout");
	    
	    if (l == R.layout.pointlayouttwo) {
	    	makeTimedMessage(3, "You've come to the medic with a wounded leg to be amputated!");
	    	makeTimedMessage(8, "You take a drink of whiskey...");
	    	makeTimedMessage(13, "The medic has made his first incision.");
	    	makeTimedMessage(19, 300, "He's hit your thighbone, time for the saw...");
	    	makeTimedMessage(25, 700, "Through the bone.");
	    	makeTimedMessage(30, "Your leg has now been fully removed");
	    }
	    
	    for(CountDownTimer t : timers) {
	    	t.start();
	    }
	}
	
	//makes a toast based on absolute time after opening exhibit and what message to display
	//overload lets you specify a vibration time in milliseconds
	public void makeTimedMessage (int t, final String s) {
		timers.add(new CountDownTimer(t*1000, 1000) {
    		public void onTick(long millisUntilFinished) {
    	        
    	    }

    	    public void onFinish() {
	    	    	Toast toast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
	    	    	toast.show();
    	    }
    	});
	}
	
	public void makeTimedMessage (int t, final int vt, final String s) {
		timers.add(new CountDownTimer(t*1000, 1000) {
    		public void onTick(long millisUntilFinished) {
    	        
    	    }

    	    public void onFinish() {
    	    	Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    	    	v.vibrate(vt);
    	    	Toast toast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
    	    	toast.show();
    	    }
    	});
	}
	
	private void stopTimers() {
		for(CountDownTimer t : timers) {
			t.cancel();
		}
	}
	
	public void onCloseClick(View view) {
		super.stopPlayers();
		Log.v("executing method:", "TimerActivity.onCloseClick()");
		stopTimers();
		finish();
		return;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		super.stopPlayers();
		if (keyCode == KeyEvent.KEYCODE_BACK) {
		    Log.d("event:","Back key pressed");
		   	stopTimers();
		    finish();
		    return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
