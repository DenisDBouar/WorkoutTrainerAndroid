package com.example.workouttrainer;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChouseEActionActivity extends Activity implements OnClickListener{
	private String type;
	private Button btnInstruction;
	private Button btnStartWorkout;
	private Button btnVideo;
	
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.chouse_e_action);
	    
	    Intent intent = getIntent();
	    type = intent.getStringExtra("type");
	    Log.d("myLogs", "ChouseEActionActivity: type = " + type );
	    
	    
	    btnInstruction = (Button) findViewById(R.id.btnInstruction);
	    btnInstruction.setOnClickListener(this);
        
	    btnStartWorkout = (Button) findViewById(R.id.btnStartWorkout);
	    btnStartWorkout.setOnClickListener(this);
        
	    btnVideo = (Button) findViewById(R.id.btnVideo);
	    btnVideo.setOnClickListener(this);
	 }

	@Override
	public void onClick(View arg0) {
		Intent intent = null;
		switch (arg0.getId()) {
	    case R.id.btnInstruction:
	    	intent = new Intent(this, Instructions.class);
	      break;
	    case R.id.btnStartWorkout:
	    	intent = new Intent(this, StartWorout.class);
	      break;
	    case R.id.btnVideo:
	    	intent = new Intent(this, VideoWorout.class);
	      break;
	    default:
	      break;
	    }
		  intent.putExtra("type", type);
	      startActivity(intent);
	}

}
