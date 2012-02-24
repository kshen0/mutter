package edu.upenn.cis350;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class ExhibitView extends View {

	private Canvas canvas;
	private Context context;

	public ExhibitView(Context context) {
		super(context);
		this.context = context;
		canvas = new Canvas();
		Drawable bg = Drawable.createFromPath("@drawable/floorplan");
		setBackgroundDrawable(bg);
	}
	
	public ExhibitView(Context c, AttributeSet a) {
		super(c);
		context = c;
		canvas = new Canvas();
		Drawable bg = Drawable.createFromPath("@drawable/floorplan");
		setBackgroundDrawable(bg);
	
	}

	protected void onDraw(Canvas canvas) {
		Point p1 = new Point(context);
		p1.setValues(300, 300, 10);
		p1.draw(canvas);

	}

}
