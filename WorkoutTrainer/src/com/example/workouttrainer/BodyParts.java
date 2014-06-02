package com.example.workouttrainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;

public class BodyParts extends Activity {

	  final String LOG_TAG = "myLogs";

	  ListView lvBodyParts;
	  
	  // имена атрибутов для Map
	  final String ATTRIBUTE_NAME_TEXT = "text";
	  final String ATTRIBUTE_NAME_DESCRIPTION = "desc";
	  final String ATTRIBUTE_NAME_IMAGE = "image";
	  private Integer[] mImageIds = {
	          R.drawable.ec_chest,
	          R.drawable.ec_back,
	          R.drawable.ec_legs,
	          R.drawable.ec_shoulders,
	          R.drawable.ec_arms,
	          R.drawable.ec_abdominals,
	  };

	  /** Called when the activity is first created. */
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.bodyparts);
	    
	    // массивы данных
	    Resources res = getResources();
	    String[] texts = res.getStringArray(R.array.names);
	    String[] descriptions = res.getStringArray(R.array.descriptions);
	    

	    // упаковываем данные в понятную для адаптера структуру
	    ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(texts.length);
	    Map<String, Object> m;
	    for (int i = 0; i < texts.length; i++) {
	      m = new HashMap<String, Object>();
	      m.put(ATTRIBUTE_NAME_IMAGE, mImageIds[i]);
	      m.put(ATTRIBUTE_NAME_TEXT, texts[i]);
	      m.put(ATTRIBUTE_NAME_DESCRIPTION, descriptions[i]);
	      data.add(m);
	    }

	    // массив имен атрибутов, из которых будут читаться данные
	    String[] from = { ATTRIBUTE_NAME_DESCRIPTION, ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_IMAGE };
	    // массив ID View-компонентов, в которые будут вставлять данные
	    int[] to = { R.id.tvDes, R.id.tvText, R.id.ivImg };

	    // создаем адаптер
	    SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.bodyparts_list, from, to);

	    // определяем список и присваиваем ему адаптер
	    lvBodyParts = (ListView) findViewById(R.id.lvBodyParts);
	    lvBodyParts.setAdapter(sAdapter);
	    
	    lvBodyParts.setOnItemClickListener(new OnItemClickListener() {
	      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//	        Log.d(LOG_TAG, "itemClick: position = " + position + ", id = " + id);
	       openExActivity(position);
	      }
	    });

	    lvBodyParts.setOnScrollListener(new OnScrollListener() {
	      public void onScrollStateChanged(AbsListView view, int scrollState) {
	      }

	      public void onScroll(AbsListView view, int firstVisibleItem,
	          int visibleItemCount, int totalItemCount) {
	      }
	    });

	  }
	  public void openExActivity(int position){
		  Intent intent = new Intent(this, ExercisesActivity.class);
		  intent.putExtra("type", String.valueOf(position));
	      startActivity(intent);
		}
	}
