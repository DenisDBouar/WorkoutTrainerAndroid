package com.example.workouttrainer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoWorout extends Activity {
	private String type;
	
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.videoworout);
	    
	    Intent intent = getIntent();
	    type = intent.getStringExtra("type");

	    Log.d("myLogs", "itemClick: type = " + type );
	    
	     VideoView videoView = (VideoView) findViewById(R.id.videoView1);
	     MediaController mediaController = new MediaController(this);
	     mediaController.setAnchorView(videoView);
	       String videoToPlay = "http://bffmedia.com/bigbunny.mp4";
	       Uri video = Uri.parse(videoToPlay);
	     videoView.setMediaController(mediaController);
	    videoView.setVideoURI(video);
	    videoView.start();
	 }

}
