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

	// better way to do this? xml?
	/*
	 * right now: ArrayList of ints in Mutter Activity -> passed by intent to
	 * PathActivity -> creates ExhibitView -> parses + passes point coords to
	 * ExhibitView problem: gracefully passing which id is connected to which
	 * point
	 */
	private void setupPoints(int ID) {
		// ID determines which points to set up
		// 0 -> Nurse path
		// 1 -> African American soldier path

		// set up point coordinates for nurse
		// HashSet<int[]> nursePoints = new HashSet<int[]>();
		ArrayList<Integer> points = new ArrayList<Integer>();
		if (ID == 0) {  //Nurse
			points.clear();
			points.add(160); //P1 x
			points.add(197); //P1 y
			points.add(0); //P1 iconID
			points.add(R.layout.nursepoint); //P1 layout
			points.add(136); //P2 x
			points.add(328); //P2 y
			points.add(0); //P2 iconID
			points.add(R.layout.pointlayouttwo);
			points.add(28);  //P3 x
			points.add(124); //P3 y
			points.add(1); //P3 iconID
			points.add(R.layout.point3layout);
			pointCoords.put(R.layout.nurselayout, points);
		}
		if (ID == 1){ //African American Soldier
<<<<<<< HEAD
			points.clear();
			points.add(155);
			points.add(135);
			points.add(R.layout.pointselectedlayout);
=======
			points.add(160); //P1 x
			points.add(197); //P1 y
			points.add(0);
			points.add(R.layout.pointselectedlayout); 
>>>>>>> d198f96f33d4cbbf33facf735d091d2aa6140538
			pointCoords.put(R.layout.africansoldierlayout, points);
		}
	}
}
