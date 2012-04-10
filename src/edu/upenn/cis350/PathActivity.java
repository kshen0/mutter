package edu.upenn.cis350;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.WallpaperManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class PathActivity extends Activity {
	private static ExhibitView exhibitView;
	private HashMap<Point, Integer> points;
	private int layoutId;

	
	private static final int DEATHS_DIALOG = 0;
	long start;
    long finish;
    double deathrate = 5.3;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// garbage collect
		System.gc();
		
		// get intent information
		Bundle b = getIntent().getExtras();
		
		// set layout
	    layoutId = b.getInt("layout");
		setContentView(layoutId);
		
		// set background
		/*
		WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
		if(layoutId == R.layout.africansoldierlayout) {
			try {
				wallpaperManager.setResource(R.drawable.floorplan_nb);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(layoutId == R.layout.nurselayout) {
			try {
				wallpaperManager.setResource(R.drawable.floorplan_path2_small);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		// set up clickable points
	    ArrayList<Integer> pointCoords = b.getIntegerArrayList("point coordinates");
	    int side = b.getInt("side size");
	    points = new HashMap<Point, Integer>();
	    initializeExhibitView(pointCoords, side);
	    System.out.println("oncreate");
	    
	    /*
	   	InputStream in;
		try {
			//in = getResources().getAssets().open("C:/Users/Kevin/workspace/mutter/res/drawable-mdpi/floorplan_nb.png");
		    in = getResources().getAssets().open("\\res\\drawable-mdpi\\floorplan_nb.png");
			BitmapDrawable bitmap = new BitmapDrawable(decodeFile(in));
		    getWindow().setBackgroundDrawable(bitmap);
          } catch (IOException e) {
			e.printStackTrace();
		} 
		*/

	   
	    //System.out.println(in.readLine());
	    
	    //timer stuff for body count
	    
	    start = System.currentTimeMillis();
	    
	}
	
	protected Dialog onCreateDialog(int id) {
    	if (id == DEATHS_DIALOG) {
	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
                // this is the message to display
	    	float time = (finish-start)/1000.0f;
	    	builder.setMessage("While you were viewing the exhibition, " + (int)(deathrate*time) + " people would have died in the war."); 
                // this is the button to display
	    	builder.setPositiveButton("Continue",
	    		new DialogInterface.OnClickListener() {
                           // this is the method to call when the button is clicked 
	    	           public void onClick(DialogInterface dialog, int id) {
	    	        	   dialog.cancel();
	    	        	   finish();
	    	           }
	    	         });
    		return builder.create();
    	}
    	else return null;
    }
	
	private void initializeExhibitView(ArrayList<Integer> coords, int side) {
		if(coords.size() % 4 != 0) {
			throw new IllegalArgumentException("list of coordinates is invalid");
		}
		exhibitView = (ExhibitView) findViewById(R.id.exhibitView);
		for(int i = 0; i < coords.size()-2; i= i+4) {
			exhibitView.addPoint(coords.get(i), coords.get(i+1), side, coords.get(i+2), coords.get(i+3));
		}
		points = exhibitView.getPoints();
	}

	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN) {
			int touchX = (int) event.getX();
			int touchY = (int) event.getY() - 77;
			for (Point point : points.keySet()) {
				Rect r = point.getBounds();
				Log.v("rect dimensions", "bounding box = " + r.left + ", "
						+ r.top + ", " + r.right + ", " + r.bottom);
				Log.v("point dimensions", "x, y = " + touchX + ", " + touchY);
				if (point.getBounds().contains(touchX, touchY)) {
					Intent intent = new Intent(this, TimerActivity.class);
					intent.putExtra("layout", points.get(point));
					startActivity(intent);
				}
			}
		}
		return false;
	}
	
	private Bitmap decodeFile(InputStream f){
		  // try {
		       //Decode image size
		       BitmapFactory.Options o = new BitmapFactory.Options();
		       o.inJustDecodeBounds = true;
		       o.inSampleSize = 2;
		       BitmapFactory.decodeStream(f,null,o);

		       //The new size we want to scale to
		       final int REQUIRED_SIZE=70;

		       //Find the correct scale value. It should be the power of 2.
		       int scale=1;
		       while(o.outWidth/scale/2>=REQUIRED_SIZE && o.outHeight/scale/2>=REQUIRED_SIZE)
		           scale*=2;

		       //Decode with inSampleSize
		       BitmapFactory.Options o2 = new BitmapFactory.Options();
		       o2.inSampleSize=scale;
		       return BitmapFactory.decodeStream(f, null, o2);
		//   } 
		  // catch (FileNotFoundException e) {}
		  // return null;
		}
	
	/*
	//decodes image and scales it to reduce memory consumption
	private Bitmap decodeFile(File f){
	    try {
	        //Decode image size
	        BitmapFactory.Options o = new BitmapFactory.Options();
	        o.inJustDecodeBounds = true;
	        o.inSampleSize = 2;
	        BitmapFactory.decodeStream(new FileInputStream(f),null,o);

	        //The new size we want to scale to
	        final int REQUIRED_SIZE=70;

	        //Find the correct scale value. It should be the power of 2.
	        int scale=1;
	        while(o.outWidth/scale/2>=REQUIRED_SIZE && o.outHeight/scale/2>=REQUIRED_SIZE)
	            scale*=2;

	        //Decode with inSampleSize
	        BitmapFactory.Options o2 = new BitmapFactory.Options();
	        o2.inSampleSize=scale;
	        return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
	    } catch (FileNotFoundException e) {}
	    return null;
	}
	*/
	// this should kill the activity, but it doesn't free memory allocated for the background image
	// how can we implement the Bitmap factory if we're not drawing to canvas?
	public void onNewPathClick(View view){
		finish = System.currentTimeMillis();
		showDialog(DEATHS_DIALOG);
		System.gc();
		finish();
	}
}
