package com.example.workouttrainer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bmi extends Activity implements OnClickListener{

	private TextView textbmitop;
	private EditText editTextBMI1;
	private EditText editTextBMI2;
	private Button butt_bmi;
	private TextView textView3;
	private TextView textbmibottom;
	private TextView textResult;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.bmi);
    
    textbmitop = (TextView) findViewById(R.id.textbmitop);
    textbmitop.setText(R.string.textbmitop);
    
    editTextBMI1 = (EditText) findViewById(R.id.editTextBMI1);
    editTextBMI2 = (EditText) findViewById(R.id.editTextBMI2);
    
    butt_bmi = (Button) findViewById(R.id.butt_bmi);
    butt_bmi.setOnClickListener(this);
    
    textView3 = (TextView) findViewById(R.id.textView3);
    textResult = (TextView) findViewById(R.id.textResult);
    textbmibottom = (TextView) findViewById(R.id.textbmibottom);
    textbmibottom.setText(R.string.textbmibottom);
  }
  
  @Override
	public void onClick(View arg0) {
	  	double rez=0;
	  	String bmi1 = editTextBMI1.getText().toString().replaceAll("\\s", "");
	  	String bmi2 = editTextBMI2.getText().toString().replaceAll("\\s", "");
	  	Log.d("AAA", "itemClick: position = " + bmi1.matches(".*\\D.*") + " : " + bmi2.matches(".*\\D.*"));
	  	if(bmi2.equals("0")){
	  		Toast toast = Toast.makeText( this, "Height could not be a zero!", Toast.LENGTH_LONG);
	  		toast.setGravity(Gravity.CENTER, 0, 0);
	  		toast.show();
	  	}
	  	else
	  	if(bmi1.matches(".*\\D.*") == true || bmi2.matches(".*\\D.*") == true ||
	  			bmi1.equals("") || bmi2.equals("")){
	  		 Log.d("AAA", "tttttttttttttttt = ");
	  		Toast toast = Toast.makeText( this, "Please insert and use only digits!", Toast.LENGTH_LONG);
	  		toast.setGravity(Gravity.CENTER, 0, 0);
	  		toast.show();
	  	}
	  	else{
	  		
	  		double mass = Integer.parseInt(bmi1);
	  		double height = Integer.parseInt(bmi2);
	  		rez = (mass/(height*height))*10000;
	  		textResult.setText(String.valueOf("***** BMI: " + rez + "*****"));
	  	}
	}
}