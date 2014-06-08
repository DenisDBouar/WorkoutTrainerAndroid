package com.example.workouttrainer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class DataTable extends Activity implements OnClickListener{

	public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.datatable);
    
    DBConector con = new DBConector(this);
    TextView etDate = (TextView) findViewById(R.id.textViewDataTable);
    etDate.setText(con.readData());
  }
@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	
}
}
