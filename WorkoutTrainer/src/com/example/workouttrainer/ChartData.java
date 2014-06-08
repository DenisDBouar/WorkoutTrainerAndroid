package com.example.workouttrainer;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class ChartData  extends Activity implements OnClickListener{

  /** Called when the activity is first created. */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.chartdata);
    
    DBConector con = new DBConector(this);
    
    GraphViewSeries series = new GraphViewSeries(con.readDataForChart());
    	 
    	GraphView graphView = new LineGraphView(
    								this, // context
    								"BMI Graph" // heading
    	);
    	graphView.addSeries(series); // data
    	graphView.setHorizontalLabels(new String[] {"tomorrow"});
    	//graphView.setVerticalLabels(new String[] {"60", "50", "40", "30", "20", "10", "0"});
    	graphView.getGraphViewStyle().setHorizontalLabelsColor(Color.BLUE);
    	graphView.getGraphViewStyle().setVerticalLabelsColor(Color.RED);
    	graphView.getGraphViewStyle().setTextSize(10);
    	graphView.getGraphViewStyle().setNumHorizontalLabels(5);
    	graphView.getGraphViewStyle().setNumVerticalLabels(4);
    	graphView.setViewPort(2, 4);
    	graphView.setScrollable(true);
    	graphView.setScalable(true);
    	LinearLayout layoutChart = (LinearLayout) findViewById(R.id.layoutChart);
    	layoutChart.addView(graphView);

}


@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	
}
}
