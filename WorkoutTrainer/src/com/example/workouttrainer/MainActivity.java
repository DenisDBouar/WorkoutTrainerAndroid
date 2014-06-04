package com.example.workouttrainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity implements OnClickListener{
	private Button btnexercises;
	private Button btnbmi;
	private Button btnbai;
	private Button btnmotivation;
	private Button progress;


  /** Called when the activity is first created. */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    btnexercises = (Button) findViewById(R.id.btnexercises);
    btnexercises.setOnClickListener(this);
    
    btnbmi = (Button) findViewById(R.id.btn_bmi);
    btnbmi.setOnClickListener(this);
    
    btnmotivation = (Button) findViewById(R.id.btn_motivation);
    btnmotivation.setOnClickListener(this);
    
    progress = (Button) findViewById(R.id.btn_progress);
    progress.setOnClickListener(this);
  }
  
  @Override
	public void onClick(View arg0) {
		Intent intent = null;
		switch (arg0.getId()) {
	    case R.id.btnexercises:
	    	intent = new Intent(this, BodyParts.class);
	      break;
	    case R.id.btn_bmi:
	    	intent = new Intent(this, Bmi.class);
	      break;
	    case R.id.btn_motivation:
	    	intent = new Intent(this, Motivation.class);
	      break;
	    case R.id.btn_progress:
	    	intent = new Intent(this, Process.class);
	      break;
	    default:
	      break;
	    }
	  startActivity(intent);
	}
}