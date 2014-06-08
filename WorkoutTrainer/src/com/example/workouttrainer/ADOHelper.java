package com.example.workouttrainer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ADOHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "workoutDB";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "MyData";
	 
	private static final String COLUMN_ID = "Id";
	private static final String COLUMN_DATE = "Date";
	private static final String COLUMN_VALUE = "Value";
	 
	public ADOHelper(Context context) {
      super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      Log.d("myLogs", "--- onCreate database ---");
      db.execSQL("create table "+TABLE_NAME+" ("
          + COLUMN_ID +" integer primary key autoincrement," 
          + COLUMN_DATE+" text,"
          + COLUMN_VALUE+" text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
  }
