package edu.upenn.cis350;

import java.util.ArrayList;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ExhibitView extends View {

	private Canvas canvas;
	private Context context;
	private ArrayList<Point> points;

	public ExhibitView(Context context) {
		super(context);
		this.context = context;
		canvas = new Canvas();
		Drawable bg = Drawable.createFromPath("@drawable/floorplan");
		setBackgroundDrawable(bg);
		points = new ArrayList<Point>();
	}
	
	public ExhibitView(Context c, AttributeSet a) {
		super(c);
		context = c;
		canvas = new Canvas();
		Drawable bg = Drawable.createFromPath("@drawable/floorplan");
		setBackgroundDrawable(bg);
		points = new ArrayList<Point>();
	
	}

	protected void onDraw(Canvas canvas) {
		Point p1 = new Point(context);
		p1.setValues(300, 300, 10);
		p1.draw(canvas);
		points.add(p1);
		//Dialog dialog = new Dialog(context);
        //dialog.setContentView(R.layout.pointselectdialog);
        //dialog.setTitle("Exhibit Name");
        //dialog.show();

	}
	
	public Dialog makeDialog(){
		 Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.pointselectdialog);
        dialog.setTitle("Exhibit Name");
        return dialog;
		
	}
	
	public boolean onTouchEvent(MotionEvent event){
		float touchX = event.getX();
		float touchY = event.getY();
		for (int i = 0; i < points.size(); i++){
			Point point = points.get(i);
			float x = point.getX();
			float y = point.getY();
			float radius = point.getRadius();
			if ((touchX < x + radius) && (touchX > x - radius) && (touchY < y + radius) && (touchY > y - radius)){
				Dialog dialog = makeDialog();
				dialog.show();
				
				return true;
			
			}
		}
		return false;
		
	}

}
