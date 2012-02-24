package edu.upenn.cis350;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class Point extends ImageView{
	
	private int x;
	private int y;
	private int radius;
	private Drawable icon;
	
	public Point(Context c) {
		super(c);
		icon = Drawable.createFromPath("@drawable/button");
		setImageDrawable(icon);
		x = 0;
		y = 0;
		radius = 0;
	}
	
	public Point(Context c, AttributeSet a) {
		super(c);
		icon = Drawable.createFromPath("@drawable/button");
		setImageDrawable(icon);
		x = 0;
		y = 0;
		radius = 0;
	}

	public void setValues(int x, int y, int radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void draw(Canvas canvas){
		//icon.setBounds(x, y, x+width, y+height);
		//icon.draw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		canvas.drawCircle(x, y, radius, paint);
	}

}
