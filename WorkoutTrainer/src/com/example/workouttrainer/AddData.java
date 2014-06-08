package com.example.workouttrainer;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddData  extends Activity implements OnClickListener{
	final String LOG_TAG = "myLogs";
	Button btnAdd, btnDeleteAll, btnUpdate;
	TextView etValue;


DateFormat format = DateFormat.getDateInstance();
Calendar calendar = Calendar.getInstance();
TextView etDate;
Button butBB;
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.adddata);
    
    btnAdd = (Button) findViewById(R.id.btnAdd);
    btnAdd.setOnClickListener(this);

    btnDeleteAll = (Button) findViewById(R.id.btndeleteall);
    btnDeleteAll.setOnClickListener(this);

    btnUpdate = (Button) findViewById(R.id.btnUpdate);
    btnUpdate.setOnClickListener(this);
    
    
    
    etDate = (TextView) findViewById(R.id.textViewCurrentDate);
    butBB = (Button) findViewById(R.id.butSetDate);
    butBB.setOnClickListener(this);
    
    

    etValue = (EditText) findViewById(R.id.etValue);
    apdateDate(); 
  }

  	public void apdateDate(){
  		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
  		etDate.setText(sdf.format(calendar.getTime()));
  	}

	@Override
	public void onClick(View v) {
	    
	    
	    String date = etDate.getText().toString();
	    String value = etValue.getText().toString().replaceAll("\\s", "");
	    DBConector con = new DBConector(this);
	    
	      
		  	Log.d("AAA", "itemClick: position = " + value.matches(".*\\D.*"));
		  	if(value.equals("0")){
		  		showMessage("BMI could not be a zero!");
		  	}
		  	else
		  	if(value.matches(".*\\D.*") == true || value.equals("")){
		  		showMessage("Available only [0-9] and '.']!");
		  	}
		  	else{
		  		
		  		switch (v.getId()) {
			    case R.id.btnAdd:{
			    	con.insertData(date, value);
			    	showMessage("Data aded");
			    }
			      break;
			    case R.id.btndeleteall:{
			    	con.deleteAll();
			    	showMessage("All deleted");
		  		}
			      break;
			    case R.id.butSetDate:
			    	setDate();
			      break;
			    case R.id.btnUpdate:
			    	con.updateData(date, value);
			    	showMessage("Data ipdated");
			      break;
		  	}
	    
	    }
	    
	}

	public void setDate(){
		new DatePickerDialog(AddData.this, d, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH)).show(); 
	}
	
	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			 calendar.set(Calendar.YEAR, year);
			 calendar.set(Calendar.MONTH, monthOfYear);
			 calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			 apdateDate();
		}
	};

	public void showMessage(String str){
		Toast toast = Toast.makeText( this, str, Toast.LENGTH_LONG);
  		toast.setGravity(Gravity.CENTER, 0, 0);
  		toast.show();
	}

}

