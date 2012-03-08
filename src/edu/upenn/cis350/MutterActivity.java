package edu.upenn.cis350;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MutterActivity extends Activity {
	
	private static ExhibitView exhibitView;
	private ArrayList<Point> points;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        exhibitView = (ExhibitView) findViewById(R.id.exhibitView);
        //why doesn't this work?
        //points = exhibitView.getPoints();
        
    }
    
    public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		if (points == null) return false;
		if (action == MotionEvent.ACTION_DOWN) {
			float touchX = event.getX();
			float touchY = event.getY();
//			if (dialogUp == true) {
//				dialog.cancel();
//				dialogUp = false;
//				return true;
//			} else {

				for (int i = 0; i < points.size(); i++) {
					Point point = points.get(i);
					float x = point.getX();
					float y = point.getY();
					float radius = point.getRadius();
					if ((touchX < x + radius) && (touchX > x - radius)
							&& (touchY < y + radius) && (touchY > y - radius)) {
						Intent intent = new Intent(this, SelectPointActivity.class);
						startActivity(intent);
						//setDialog();
						//dialog.show();
						//dialogUp = true;
						return true;

					}
				}
			}
		//}
		return false;
	}
}