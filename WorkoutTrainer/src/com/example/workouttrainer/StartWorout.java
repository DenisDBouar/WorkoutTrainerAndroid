package com.example.workouttrainer;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.ViewSwitcher.ViewFactory;
import android.view.ViewGroup.LayoutParams;

public class StartWorout extends Activity {
	private String type;
	
	
	ImageSwitcher imageSwitcher;
	Animation slide_in_left, slide_out_right;
	String[] texts;
	int ise;

	 int imageResources[] = { 
	   android.R.drawable.ic_dialog_alert,
	   android.R.drawable.ic_dialog_dialer,
	   android.R.drawable.ic_dialog_email,
	   android.R.drawable.ic_dialog_info, 
	   android.R.drawable.ic_dialog_map };
	 
	
	
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.startworout);
	    
	    Intent intent = getIntent();
	    type = intent.getStringExtra("type");
	    
	    Log.d("myLogs", "StartWorout: type = " + type );

	    Resources res = getResources();
	    texts = res.getStringArray(getIntResourceByName("array", "sw" + type));
	    for(int i=0; i<texts.length; i++){
	    	addImageToTableRow(getIntResourceByName("drawable", texts[i]));
	    }
	    
	    
	    
	    
	    
	    
	    addImageSToTableRow();
	    imageSwitcher = (ImageSwitcher) findViewById(12345);

	    slide_in_left = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
	    slide_out_right = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

	    imageSwitcher.setInAnimation(slide_in_left);
	    imageSwitcher.setOutAnimation(slide_out_right);

	    imageSwitcher.setFactory(new ViewFactory() {

	     @Override
	     public View makeView() {

	      ImageView imageView = new ImageView(StartWorout.this);
	      imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

	      LayoutParams params = new ImageSwitcher.LayoutParams(
	        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

	      imageView.setLayoutParams(params);
	      return imageView;

	     }
	    });

		    imageSwitcher.postDelayed(new Runnable() {
		    	int index = 0;
	            public void run() {
	            	if(index == texts.length-1)
	            		index =0;
	            	else
	            		++index;
	            	imageSwitcher.setImageResource(getIntResourceByName("drawable", texts[index]));
	                imageSwitcher.postDelayed(this, 1000);
	            }
	        }, 1000);
	   
	 }
	
	private void addImageToTableRow(int res){
		ImageView tv11 = new ImageView(this);  
	    tv11.setImageResource(res);
	    TableRow tableRow3 =(TableRow)findViewById(R.id.trStartWorkout);         
	    int RGB1 = android.graphics.Color.rgb(223, 223, 223); 
	    tableRow3.setBackgroundColor(RGB1); 
	    tableRow3.addView(tv11);
	}
	
	private void addImageSToTableRow(){
		ImageSwitcher tv11 = new ImageSwitcher(this);  
	    tv11.setId(12345);
	    TableRow tableRow3 =(TableRow)findViewById(R.id.trStartWorkout);         
	    int RGB1 = android.graphics.Color.rgb(223, 223, 223); 
	    tableRow3.setBackgroundColor(RGB1); 
	    tableRow3.addView(tv11);
	}
	
	private int getIntResourceByName(String defType, String aString) {
	      String packageName = getPackageName();
	      int resId = getResources().getIdentifier(aString, defType, packageName);
	      return resId;
	    }
	

}
