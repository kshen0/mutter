package edu.upenn.cis350;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;



public class PointActivityTwo extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pointlayouttwo);
	}
	
	public void onCloseClick(View view){
		finish();
	}

}
