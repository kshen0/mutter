package edu.upenn.cis350;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class Point extends ImageView{
	
	private float x;
	private float y;
	private float radius;
	private Drawable icon;
	private Context context;
	
	public Point(Context c) {
		super(c);
		icon = Drawable.createFromPath("@drawable/button");
		setImageDrawable(icon);
		x = 0;
		y = 0;
		radius = 0;
		context = c;
	}
	
	public Point(Context c, AttributeSet a) {
		super(c);
		icon = Drawable.createFromPath("@drawable/button");
		setImageDrawable(icon);
		x = 0;
		y = 0;
		radius = 0;
		context = c;
	}

	public void setValues(float x, float y, float radius){
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
	
//	public boolean onTouchEvent(MotionEvent event){
//		int action = event.getAction();
//		float touchx = event.getX();
//		float touchy = event.getY();
//		if ((touchx < x + radius) && (touchx > x - radius) && (touchy < y + radius) && (touchy > y - radius)){
//			Dialog dialog = makeDialog();
//			dialog.show();
//			return true;
//		}
//		else{
//			Dialog dialog = makeDialog();
//			dialog.show();
//			return false;
//		}
//		
//	}
	
//	public Dialog makeDialog(){
//		 Dialog dialog = new Dialog(context);
//         dialog.setContentView(R.layout.pointselectdialog);
//         dialog.setTitle("Exhibit Name");
//         return dialog;
//		
//	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	
	}
	
	public float getRadius(){
		return radius;
	}
	
}
