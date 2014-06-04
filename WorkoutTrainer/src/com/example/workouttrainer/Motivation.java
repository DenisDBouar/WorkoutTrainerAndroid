package com.example.workouttrainer;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class Motivation extends Activity {
	
	Gallery mGallery;
	ImageAdapter mImageAdapter;
	ImageView gal_imageView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        
        gal_imageView = (ImageView)findViewById(R.id.gal_imageView);
        
        mGallery = (Gallery) findViewById(R.id.gallery);
        
        mImageAdapter = new ImageAdapter(this);  
        mGallery.setAdapter(mImageAdapter);
        
        mGallery.setSelection(mImageAdapter.getCount() / 2);
        
        mGallery.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
				gal_imageView.setImageResource(Sourcem.imMotivation[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				gal_imageView.setImageResource(Sourcem.imMotivation[0]);
			}
        });
    }
    
    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;
        
        public ImageAdapter(Context c) {
            mContext = c;
            TypedArray attr = mContext.obtainStyledAttributes(R.styleable.MyGallery);
            mGalleryItemBackground = attr.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
            attr.recycle();
        }

        public int getCount() {
            return Sourcem.imMotivation.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(Sourcem.imMotivation[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(70, 70));
            imageView.setBackgroundResource(mGalleryItemBackground);
            return imageView;
        }
    }
    
}