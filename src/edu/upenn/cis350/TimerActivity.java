package edu.upenn.cis350;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class TimerActivity extends SelectPointActivity {
	boolean stop;
	@Override
    public void onCreate(Bundle savedInstanceState) {
		stop = false;
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.pointselectedlayout);
        
        
        Bundle b = getIntent().getExtras();
		int l = 0;
		l = b.getInt("layout");
	    //setContentView(l);
		showMessage = true;
	    
	    
	    if (l == R.layout.pointlayouttwo) {
	    	makeTimedMessage(3, "You've come to the medic with a wounded leg to be amputated!");
	    	makeTimedMessage(10, "You take a drink of whiskey...");
	    	makeTimedMessage(16, "The medic has made his first incision.");
	    	makeTimedMessage(24, 300, "He's hit your thighbone, time for the saw...");
	    	makeTimedMessage(30, 700, "Through the bone.");
	    	makeTimedMessage(40, "Your leg has now been fully removed");
	    }
	}
	
	//makes a toast based on absolute time after opening exhibit and what message to display
	//overload lets you specify a vibration time in milliseconds
	public void makeTimedMessage (int t, final String s) {
		if (showMessage == false)
			return;
		new CountDownTimer(t*1000, 1000) {
    		public void onTick(long millisUntilFinished) {
    	        
    	    }

    	    public void onFinish() {
    	    	if(!stop) {
	    	    	Toast toast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
	    	    	toast.show();
    	    	}
    	    }
    	}.start();
	}
	
	public void makeTimedMessage (int t, final int vt, final String s) {
		if (showMessage == false)
			return;
		new CountDownTimer(t*1000, 1000) {
    		public void onTick(long millisUntilFinished) {
    	        
    	    }

    	    public void onFinish() {
    	    	Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    	    	v.vibrate(vt);
    	    	Toast toast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
    	    	toast.show();
    	    }
    	}.start();
	}
	
	public void onCloseClick(View view) {
		stop = true;
		finish();
		return;
	}
}
