package com.example.workouttrainer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WProgress extends Activity implements OnClickListener{
	private Button btnAddData;
	private Button btnChart;
	private Button btnDataTable;


  /** Called when the activity is first created. */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.wprogress);
    
    btnAddData = (Button) findViewById(R.id.btnAddData);
    btnAddData.setOnClickListener(this);
    
    btnChart = (Button) findViewById(R.id.btnChart);
    btnChart.setOnClickListener(this);
    
    btnDataTable = (Button) findViewById(R.id.btnDataTable);
    btnDataTable.setOnClickListener(this);
    
  }
  
  @Override
	public void onClick(View arg0) {
		Intent intent = null;
		switch (arg0.getId()) {
	    case R.id.btnAddData:
	    	intent = new Intent(this, AddData.class);
	      break;
	    case R.id.btnChart:
	    	intent = new Intent(this, ChartData.class);
	      break;
	    case R.id.btnDataTable:
	    	intent = new Intent(this, DataTable.class);
	      break;
	    default:
	      break;
	    }
	  startActivity(intent);
	}
}

