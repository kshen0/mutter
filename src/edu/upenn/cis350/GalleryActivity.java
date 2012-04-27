package edu.upenn.cis350;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class GalleryActivity extends Activity{
	Integer[] imageIDs = {
            R.drawable.aasoldier,
            R.drawable.hancock_cornelia_portrait,
            R.drawable.hospital1,
            R.drawable.hospital2,
            R.drawable.nurse,
            R.drawable.contraband
    };
	String[] imageStrings = {
			"An African American soldier",
			"A portrait of Hancock Cornelia",
			"A view of a hospital",
			"An alternate view of a hospital",
			"A nurse sits with her patient",
			"An injured contraband"
	};
	
	@Override    
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallerylayout);
 
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
 
        gallery.setAdapter(new ImageAdapter(this));        
        gallery.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView parent, 
            View v, int position, long id) 
            {                
            	ImageView imageView = (ImageView) findViewById(R.id.image1);                
                imageView.setImageResource(imageIDs[position]);
                Toast.makeText(getBaseContext(), 
                        imageStrings[position], 
                        Toast.LENGTH_SHORT).show();
            }
        }); 
    }
	
	public class ImageAdapter extends BaseAdapter 
    {
        private Context context;
        private int itemBackground;
 
        public ImageAdapter(Context c) 
        {
            context = c;
            //---setting the style---
            TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
            itemBackground = a.getResourceId(
                R.styleable.Gallery1_android_galleryItemBackground, 0);
            a.recycle();                    
        }
 
        //---returns the number of images---
        public int getCount() {
            return imageIDs.length;
        }
 
        //---returns the ID of an item--- 
        public Object getItem(int position) {
            return position;
        }            
 
        public long getItemId(int position) {
            return position;
        }
 
        //---returns an ImageView view---
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIDs[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }  
	
	public void onBackClick(View view){
		finish();
	}

}
