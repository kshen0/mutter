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
	private int layoutType;
	
	public Point(Context c) {
		super(c);
		icon = getResources().getDrawable(R.drawable.button_off_small_padded);
		setImageDrawable(icon);
		x = 0;
		y = 0;
		side = 0;
		context = c;
		layoutType = 0;
	}
	
	public Point(Context c, AttributeSet a) {
		super(c, a);
		icon = getResources().getDrawable(R.drawable.button_off_small_padded);
		setImageDrawable(icon);
		x = 0;
		y = 0;
		side = 0;
		context = c;
		layoutType = 0;
	}

	public void setValues(int x, int y, int s){
		this.x = x;
		this.y = y;
		this.side = s;
	}
	
	public void setLayoutType(int i){
		layoutType = i;
	}
	public int getLayoutType(){
		return layoutType;
	}
	
	public void draw(Canvas canvas){
		icon.setBounds(x, y, x+side, y+side);
		icon.draw(canvas);
		/*
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		canvas.drawCircle(x, y, radius, paint);
		*/
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
}
