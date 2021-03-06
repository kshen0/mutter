package edu.upenn.cis350;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class Point extends ImageView{
	
	private int x;
	private int y;
	private int side;
	private Drawable icon;
	private Context context;
	private int layoutID;

	
	public Point(Context c, int x, int y, int side, int iconID, int layoutID) {
		super(c);
		if (iconID == 1)
			icon = getResources().getDrawable(R.drawable.speakericon);
		else if (layoutID == R.layout.nurselayout)
			//icon = getResources().getDrawable(R.drawable.button_off_small_padded);
			icon = getResources().getDrawable(R.drawable.blue45);
		else 
			icon = getResources().getDrawable(R.drawable.orange45);
		setImageDrawable(icon);
		this.x = dipToPx(x);
		this.y = dipToPx(y);
		this.side = dipToPx(side);
		context = c;
		this.layoutID = layoutID;
		
	}
	
	// why is this necessary?
	public Point(Context c, AttributeSet a) {
		super(c, a);

		icon = getResources().getDrawable(R.drawable.blue45);
		setImageDrawable(icon);
		x = 0;
		y = 0;
		side = 0;
		context = c;

	}

	private int dipToPx(int i) {
		float density = getResources().getDisplayMetrics().density;
		float px = i * density;
		Log.v("density", "" + density);
		//Resources r = getResources();
		//float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, r.getDisplayMetrics());
		return (int) px;
	}
	
	// pass arguments in as dip
	public void setValues(int x, int y, int s){
		// Convert dip into its equivalent px
		Resources r = getResources();
		float xdip = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, x, r.getDisplayMetrics());
		float ydip = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, y, r.getDisplayMetrics());
		float sdip = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, y, r.getDisplayMetrics());
		Log.v("dp values", "x, y, s = " + xdip + ", "
				+ ydip + ", " + sdip);
		this.x = (int) xdip;
		this.y = (int) ydip;
		this.side = (int) sdip;
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
