package edu.upenn.cis350;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MutterActivity extends Activity {

	private static ExhibitView exhibitView;
	private ArrayList<Point> points;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		int a = R.id.exhibitView;
		exhibitView = (ExhibitView) findViewById(R.id.exhibitView);
		// why doesn't this work??

		points = exhibitView.getPoints();

	}

	public boolean onTouchEvent(MotionEvent event) {
		exhibitView = (ExhibitView) findViewById(R.id.exhibitView);
		// if (exhibitView == null) return false;
		points = exhibitView.getPoints();
		// if (points == null) return false;
		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN) {
			int touchX = (int) event.getX();
			int touchY = (int) event.getY() - 77;
			for (Point point : points) {
				Rect r = point.getBounds();
				Log.v("rect dimensions", "bounding box = " + r.left + ", "
						+ r.top + ", " + r.right + ", " + r.bottom);
				Log.v("point dimensions", "x, y = " + touchX + ", " + touchY);
				if (point.getBounds().contains(touchX, touchY)) {
					if (point.getLayoutType() == 0) {
						Intent intent = new Intent(this,
								SelectPointActivity.class);
						startActivity(intent);
						return true;
					}
					else if (point.getLayoutType() == 1){
						Intent intent = new Intent(this, PointActivityTwo.class);
						startActivity(intent);
						return true;
					}
				}
			}
		}
		return false;
	}
}
