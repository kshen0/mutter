package edu.upenn.cis350;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MutterActivity extends Activity {

	// map containing key: layout id, value: int array of 3 values (x, y, button
	// side length)
	private HashMap<Integer, ArrayList<Integer>> pointCoords;
	private static final int SIDE = 30;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		pointCoords = new HashMap<Integer, ArrayList<Integer>>();
		
		//this is timer stuff for the bodycount
		//long start;
		//long finish;
		

	}

	public void onNurseButtonClick(View view) {
		setupPoints(0);
		Intent intent = new Intent(this, PathActivity.class);
		intent.putExtra("layout", R.layout.nurselayout);
		intent.putExtra("point coordinates",
				pointCoords.get(R.layout.nurselayout));
		intent.putExtra("side size", SIDE);
		startActivity(intent);
	}
	
	public void onAfricanSoldierButtonClick(View view){
		setupPoints(1);
		Intent intent = new Intent(this, PathActivity.class);
		intent.putExtra("layout", R.layout.africansoldierlayout);
		intent.putExtra("point coordinates",
				pointCoords.get(R.layout.africansoldierlayout));
		intent.putExtra("side size", SIDE);
		startActivity(intent);
	}
	
	public void onMusicplayerClick(View view) {
		Intent intent = new Intent(this, MusicList.class);
		startActivity(intent);
	}
	
	public void onGalleryClick(View view){
		Intent intent = new Intent(this, GalleryActivity.class);
		startActivity(intent);
	}

	// better way to do this? xml?
	/*
	 * right now: ArrayList of ints in Mutter Activity -> passed by intent to
	 * PathActivity -> creates ExhibitView -> parses + passes point coords to
	 * ExhibitView problem: gracefully passing which id is connected to which
	 * point
	 */
	private void setupPoints(int ID) {
		// ID determines which points to set up
		// 0 -> Normal button icon
		// 1 -> Sound button icon

		// set up point coordinates for nurse
		//An ArrayList of values needed for points (x coordinate, y coordinate, and ID for what kind of icon
		//the point should have)  is made for each path.  The ArrayList is stored in the pointCoords hashmap,
		//which has layouts as keys and ArrayLists as values.
		// When a path button is clicked, the correct ArrayList is gotten from pointCoords and passed into the new
		// activity by intent.
		ArrayList<Integer> points = new ArrayList<Integer>();
		if (ID == 0) {  //Nurse
			points.clear();
			points.add(173); //P1 x
			points.add(240); //P1 y
			points.add(1); //P1 iconID
			points.add(R.layout.nursepoint); //P1 layout
			points.add(145); //P2 x
			points.add(410); //P2 y
			points.add(0); //P2 iconID
			points.add(R.layout.pointlayouttwo);
			points.add(10);  //P3 x
			points.add(152); //P3 y
			points.add(1); //P3 iconID
			points.add(R.layout.point3layout);
			pointCoords.put(R.layout.nurselayout, points);
		}
		if (ID == 1){ //African American Soldier
			points.add(170); //P1 x
			points.add(220); //P1 y
			points.add(1);
			points.add(R.layout.pointselectedlayout); 
			points.add(50);
			points.add(50);
			points.add(0);
			points.add(R.layout.aa_point_two);
			
			
			pointCoords.put(R.layout.africansoldierlayout, points);
		}
	}
}
