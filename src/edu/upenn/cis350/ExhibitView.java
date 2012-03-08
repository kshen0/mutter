package edu.upenn.cis350;

import java.util.ArrayList;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ExhibitView extends View {

	private Canvas canvas;
	private Context context;
	private ArrayList<Point> points;
	private boolean dialogUp;
	private Dialog dialog;

	public ExhibitView(Context context) {
		super(context);
		this.context = context;
		canvas = new Canvas();
		// Drawable bg = Drawable.createFromPath("@drawable/floorplan_nb");
		// setBackgroundDrawable(bg);
		points = new ArrayList<Point>();
		dialogUp = false;
		dialog = new Dialog(context);
	}

	public ExhibitView(Context c, AttributeSet a) {
		super(c, a);
		context = c;
		canvas = new Canvas();
		Drawable bg = Drawable.createFromPath("@drawable/floorplan");
		setBackgroundDrawable(bg);
		points = new ArrayList<Point>();
		dialogUp = false;
		dialog = new Dialog(context);

	}

	protected void onDraw(Canvas canvas) {
		Point p1 = new Point(context);
		p1.setValues(262, 300, 10);
		p1.draw(canvas);
		points.add(p1);

	}

	public void setDialog() {
		dialog = new Dialog(context);
		dialog.setContentView(R.layout.pointselectdialog);
		dialog.setTitle("Exhibit Name");

	}

//	public boolean onTouchEvent(MotionEvent event) {
//		int action = event.getAction();
//		if (action == MotionEvent.ACTION_DOWN) {
//			float touchX = event.getX();
//			float touchY = event.getY();
//			if (dialogUp == true) {
//				dialog.cancel();
//				dialogUp = false;
//				return true;
//			} else {
//
//				for (int i = 0; i < points.size(); i++) {
//					Point point = points.get(i);
//					float x = point.getX();
//					float y = point.getY();
//					float radius = point.getRadius();
//					if ((touchX < x + radius) && (touchX > x - radius)
//							&& (touchY < y + radius) && (touchY > y - radius)) {
//						Intent intent = new Intent(this, SelectPointActivity.class);
//						startActivity(intent);
//						//setDialog();
//						//dialog.show();
//						//dialogUp = true;
//						return true;
//
//					}
//				}
//			}
//		}
//		return false;
//	}
	
	public ArrayList<Point> getPoints(){
		return points;
	}

}
