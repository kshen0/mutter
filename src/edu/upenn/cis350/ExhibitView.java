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

	public ExhibitView(Context con) {
		super(con);
		initialize(con);
		//setUpPoints();
	}

	public ExhibitView(Context con, AttributeSet a) {
		super(con, a);
		initialize(con);
		//setUpPoints();
		//Drawable bg = Drawable.createFromPath("@drawable/floorplan");
		//setBackgroundDrawable(bg);
	}
	
	private void initialize(Context con) {
		this.context = con;
		canvas = new Canvas();
		
		// key: point, value: layout id(?)
		points = new HashMap<Point, Integer>();
	}

	/*
	private void setUpPoints() {
		Point p1 = new Point(context, 160, 197, 30);
		points.put(p1, R.layout.pointselectedlayout);
		 
		Point p2 = new Point(context, 136, 328, 30);
		points.put(p2, R.layout.pointlayouttwo);
		
		Point p3 = new Point(context, 28, 124, 30);
		points.put(p3, R.layout.point3layout);
	}
	*/
	public void addPoint(int x, int y, int side, int iconID, int layout, int layoutID) {
		points.put(new Point(context, x, y, side, iconID, layoutID), layout);
	}
	
	protected void onDraw(Canvas canvas) {
		for (Point p : points.keySet()) {
			p.draw(canvas);
		}
	}
	
	public HashMap<Point, Integer> getPoints(){
		return points;
	}

}
