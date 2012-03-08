package edu.upenn.cis350;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class SelectPointActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pointselectedlayout);
	}
	
	public void onCloseClick(View view){
		finish();
	}

}
