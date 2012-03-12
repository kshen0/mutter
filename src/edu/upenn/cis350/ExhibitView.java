package edu.upenn.cis350;

import java.util.ArrayList;

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

public class ExhibitView extends View {

	private Canvas canvas;
	private Context context;
	private ArrayList<Point> points;
	private boolean dialogUp;
	private Dialog dialog;

	public ExhibitView(Context con) {
		super(con);
		// Drawable bg = Drawable.createFromPath("@drawable/floorplan_nb");
		// setBackgroundDrawable(bg);
		initialize(con);
	}

	public ExhibitView(Context con, AttributeSet a) {
		super(con, a);
		initialize(con);
		Drawable bg = Drawable.createFromPath("@drawable/floorplan");
		setBackgroundDrawable(bg);
	}
	
	private void initialize(Context con) {
		this.context = con;
		canvas = new Canvas();
		points = new ArrayList<Point>();
		dialogUp = false;
		dialog = new Dialog(context);
	}

	protected void onDraw(Canvas canvas) {
		Point p1 = new Point(context);
		p1.setValues(253, 294, 20);
		p1.draw(canvas);
		points.add(p1);
	}

	public void setDialog() {
		dialog = new Dialog(context);
		dialog.setContentView(R.layout.pointselectdialog);
		dialog.setTitle("Exhibit Name");

	}
	
	public ArrayList<Point> getPoints(){
		return points;
	}

}
