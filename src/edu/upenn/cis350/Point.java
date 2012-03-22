package edu.upenn.cis350;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class Point extends ImageView{
	
	private int x;
	private int y;
	private int side;
	private Drawable icon;
	private Context context;
	
	public Point(Context c, int x, int y, int side) {
		super(c);
		icon = getResources().getDrawable(R.drawable.button_off_small);
		setImageDrawable(icon);
		this.x = x;
		this.y = y;
		this.side = side;
		context = c;
	}
	
	// why is this necessary?
	public Point(Context c, AttributeSet a) {
		super(c, a);
		icon = getResources().getDrawable(R.drawable.button_off_small);
		setImageDrawable(icon);
		x = 0;
		y = 0;
		side = 0;
		context = c;
	}

	public void setValues(int x, int y, int s){
		this.x = x;
		this.y = y;
		this.side = s;
	}
	
	public void draw(Canvas canvas){
		icon.setBounds(x, y, x+side, y+side);
		icon.draw(canvas);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	
	}
	
	public float getSide(){
		return side;
	}
	
	public Rect getBounds() {
		return icon.getBounds();
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
