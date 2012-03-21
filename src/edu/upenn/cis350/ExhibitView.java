package edu.upenn.cis350;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;

public class ExhibitView extends View {

	private Canvas canvas;
	private Context context;
	private HashMap<Point, Integer> points;
	private boolean dialogUp;
	private Dialog dialog;

	public ExhibitView(Context con) {
		super(con);
		initialize(con);
		setUpPoints();
	}

	public ExhibitView(Context con, AttributeSet a) {
		super(con, a);
		initialize(con);
		setUpPoints();
		Drawable bg = Drawable.createFromPath("@drawable/floorplan");
		setBackgroundDrawable(bg);
	}
	
	private void initialize(Context con) {
		this.context = con;
		canvas = new Canvas();
		dialogUp = false;
		dialog = new Dialog(context);
		
		// key: point, value: layout id(?)
		points = new HashMap<Point, Integer>();
	}

	private void setUpPoints() {
		Point p1 = new Point(context);
		p1.setValues(253, 294, 20);
		points.put(p1, R.layout.pointselectedlayout);
		
		Point p2 = new Point(context);
		p2.setValues(230,500,20);
		p2.setLayoutType(0);
		points.put(p2, R.layout.pointlayouttwo);
	}
	
	protected void onDraw(Canvas canvas) {
		for (Point p : points.keySet()) {
			p.draw(canvas);
		}
	}

	public void setDialog() {
		dialog = new Dialog(context);
		dialog.setContentView(R.layout.pointselectdialog);
		dialog.setTitle("Exhibit Name");

	}
	
	public HashMap<Point, Integer> getPoints(){
		return points;
	}

}
