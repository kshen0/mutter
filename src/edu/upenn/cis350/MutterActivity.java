package edu.upenn.cis350;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MutterActivity extends Activity {

	// map containing key: layout id, value: int array of 3 values (x, y, button side length)
	private HashMap<Integer, ArrayList<Integer>> pointCoords;
	private static final int SIDE = 30;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setupPoints();
	}

	public void onNurseButtonClick(View view) {
		Intent intent = new Intent(this, PathActivity.class);
		intent.putExtra("layout", R.layout.nurselayout);
		intent.putExtra("point coordinates", pointCoords.get(R.layout.nurselayout));
		intent.putExtra("side size", SIDE);
		startActivity(intent);
	}
	
	// better way to do this? xml?
	/* right now: ArrayList of ints in Mutter Activity -> passed by intent to
	 * PathActivity -> creates ExhibitView -> parses + passes point coords to
	 *  ExhibitView
	 * problem: gracefully passing which id is connected to which point
	 */
	private void setupPoints() {
		// set up point coordinates for nurse
		//HashSet<int[]> nursePoints = new HashSet<int[]>();
		ArrayList<Integer> nursePoints = new ArrayList<Integer>();
		nursePoints.add(160);
		nursePoints.add(197);
		nursePoints.add(136);
		nursePoints.add(328);
		nursePoints.add(28);
		nursePoints.add(124);
		pointCoords.put(R.layout.nurselayout, nursePoints);
	}
}
