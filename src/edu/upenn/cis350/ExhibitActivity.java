package edu.upenn.cis350;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class ExhibitActivity extends Activity {
	private Dialog dialog;
	private static final int SAMPLE_DIALOG = 1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        showDialog(SAMPLE_DIALOG);
        // draw image on screen
    }
    
    protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		dialog = new Dialog(this);
		dialog.setContentView(R.layout.pointselectdialog);
		dialog.setTitle("Exhibit Name");
    	// make button with string display yes
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
			// exit dialog on click
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});
		return builder.create();
    }  
}
