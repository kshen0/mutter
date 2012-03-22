package edu.upenn.cis350;

import java.util.HashMap;

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
	private HashMap<Point, Integer> points;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		exhibitView = (ExhibitView) findViewById(R.id.exhibitView);
		points = exhibitView.getPoints();
	}

	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN) {
			int touchX = (int) event.getX();
			int touchY = (int) event.getY() - 109;
			for (Point point : points.keySet()) {
				Rect r = point.getBounds();
				Log.v("rect dimensions", "bounding box = " + r.left + ", "
						+ r.top + ", " + r.right + ", " + r.bottom);
				Log.v("point dimensions", "x, y = " + touchX + ", " + touchY);
				if (point.getBounds().contains(touchX, touchY)) {
					Intent intent = new Intent(this, SelectPointActivity.class);
					intent.putExtra("layout", points.get(point));
					startActivity(intent);
				}
			}
		}
		return false;
	}
}
