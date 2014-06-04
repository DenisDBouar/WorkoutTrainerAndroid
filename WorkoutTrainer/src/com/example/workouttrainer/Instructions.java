package com.example.workouttrainer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Instructions extends Activity {
	private String type;
	private ImageView mImageView;
	private TextView tvMuscul;
	
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.instructions);
	    
	    Intent intent = getIntent();
	    type = intent.getStringExtra("type");
	    String[] parts = type.split("_");
	    
	    //Log.d("myLogs", "Instructions: type = " + type  + " val:" +Integer.valueOf(parts[0]));
	    //Log.d("myLogs", "Instructions2: type = " + type  + " val:" +Sourcem.imMusculs[Integer.valueOf(parts[0])]);

	  mImageView = (ImageView)findViewById(R.id.imgMuscul);
	  mImageView.setImageResource(Sourcem.imMusculs[Integer.valueOf(parts[0])]);
	  
	  tvMuscul = (TextView) findViewById(R.id.tvMuscul);
	  tvMuscul.setText(getStringResourceByName("inf" + type));
	  
	 }
	
	private String getStringResourceByName(String aString) {
	      String packageName = getPackageName();
	      int resId = getResources().getIdentifier(aString, "string", packageName);
	      return getString(resId);
	    }

}
