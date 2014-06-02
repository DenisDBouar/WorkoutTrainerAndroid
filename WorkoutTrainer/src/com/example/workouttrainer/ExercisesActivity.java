package com.example.workouttrainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.workouttrainer.R.string;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;

public class ExercisesActivity extends Activity {
	ListView lvExe;
	private String type;
	
	final String ATTRIBUTE_NAME_TEXT = "text";
	  final String ATTRIBUTE_NAME_DESCRIPTION = "desc";
	  final String ATTRIBUTE_NAME_IMAGE = "image";
	  
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.exercises);
	    
	    Intent intent = getIntent();
	    type = intent.getStringExtra("type");
	    Log.d("myLogs", "ExercisesActivity: type = " + type);
	    
	    Resources res = getResources();
	    String[] texts = res.getStringArray(Sourcem.exercise[Integer.valueOf(type)]);

	    Integer[] imageArray = getImageArray(type);
 	    ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(texts.length);
	    Map<String, Object> m;
	    for (int i = 0; i < texts.length; i++) {
	      m = new HashMap<String, Object>();
	      m.put(ATTRIBUTE_NAME_IMAGE, imageArray[i]);
	      m.put(ATTRIBUTE_NAME_TEXT, texts[i]);
	      data.add(m);
	    }

	    String[] from = { ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_IMAGE };
	    int[] to = { R.id.eText, R.id.eImg };

	    SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.exercises_list, from, to);

	    lvExe = (ListView) findViewById(R.id.eMain);
	    lvExe.setAdapter(sAdapter);
	    
	    lvExe.setOnItemClickListener(new OnItemClickListener() {
	      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	    	//  Log.d("myLogs", "itemClick: position = " + position + ", id = " + pos);
	       //type += "_" + id;
	       openExActivity(position);
	      }
	    });

	  }
	public void openExActivity(int position){
		  Intent intent = new Intent(this, ChouseEActionActivity.class);
		  intent.putExtra("type", type + "_" + String.valueOf(position));
	      startActivity(intent);
	}
	
	public Integer[] getImageArray(String pos){
		Integer[] arr = null;
		switch (Integer.valueOf(pos)) {
		    case 0:
		    	arr = Sourcem.imChest;
			break;
		    case 1:
		    	arr = Sourcem.imBack;
			break;
		    case 2:
		    	arr = Sourcem.imLegs;
			break;
		    case 3:
		    	arr = Sourcem.imShoulders;
			break;
		    case 4:
		    	arr = Sourcem.imArms;
			break;
		    case 5:
		    	arr = Sourcem.imAbdominals;
			break;
		}
		return arr;
	} 
	
}
