package edu.upenn.cis350;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class PathActivity extends Activity {
	private static ExhibitView exhibitView;
	private HashMap<Point, Integer> points;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		setContentView(R.layout.main);
		exhibitView = (ExhibitView) findViewById(R.id.exhibitView);
		points = exhibitView.getPoints();
		*/
		Bundle b = getIntent().getExtras();
	    setContentView(b.getInt("layout"));
	    ArrayList<Integer> pointCoords = b.getIntegerArrayList("point coordinates");
	    int side = b.getInt("side size");
	    points = new HashMap<Point, Integer>();
	    initializeExhibitView(pointCoords, side);
	    System.out.println("hello");
	    
	}
	
	private void initializeExhibitView(ArrayList<Integer> coords, int side) {
		if(coords.size() % 4 != 0) {
			throw new IllegalArgumentException("list of coordinates is invalid");
		}
		exhibitView = (ExhibitView) findViewById(R.id.exhibitView);
		for(int i = 0; i < coords.size()-2; i= i+4) {
			exhibitView.addPoint(coords.get(i), coords.get(i+1), side, coords.get(i+2), coords.get(i+3));
		}
		points = exhibitView.getPoints();
	}

	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN) {
			int touchX = (int) event.getX();
			int touchY = (int) event.getY() - 77;
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
	public void onNewPathClick(View view){
		finish();
	
	}
}
