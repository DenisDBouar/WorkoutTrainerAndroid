package com.example.workouttrainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBConector {

	final String LOG_TAG = "myLogs";
	
	private static final String TABLE_NAME = "MyData";
	private static final String COLUMN_ID = "Id";
	private static final String COLUMN_DATE = "Date";
	private static final String COLUMN_VALUE = "Value";
	  
	SQLiteDatabase db;
	ADOHelper dbHelper;
	
	public DBConector(Context context){
		dbHelper = new ADOHelper(context);
		db = dbHelper.getWritableDatabase();
	}
	public void insertData(String date, String value){
		 Log.d(LOG_TAG, "--- Insert in mytable: ---");
		 ContentValues cv = new ContentValues();
	      cv.put(COLUMN_DATE, date);
	      cv.put(COLUMN_VALUE, value);
	      long rowID = db.insert(TABLE_NAME, null, cv);
	     Log.d(LOG_TAG, "row inserted, ID = " + rowID);
	     db.close();
	}
	
	public void updateData(String date, String value){
		String strSQL = "UPDATE "+ TABLE_NAME +
						" SET "+ COLUMN_VALUE +" = '"+ value +
						"' WHERE "+ COLUMN_DATE +" = '"+ date +"';";
		 Log.d(LOG_TAG, "--- Update: ---" + COLUMN_DATE + " | " + date +" | " + strSQL);
		db.execSQL(strSQL);
		db.close();
	}
	
	public void deleteAll() {
		db.delete(TABLE_NAME, null, null);
	}
	
	public void delete(long id) {
		db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
	}
	
	
	public String readData(){
		  Log.d(LOG_TAG, "--- Rows in mytable: ---");
		  String str = "";
			      Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
			      if (c.moveToFirst()) {
			        int idColIndex = c.getColumnIndex(COLUMN_ID);
			        int nameColIndex = c.getColumnIndex(COLUMN_DATE);
			        int emailColIndex = c.getColumnIndex(COLUMN_VALUE);

			        do {
			          /*Log.d(LOG_TAG, "ID = " + c.getInt(idColIndex) + 
			              ", name = " + c.getString(nameColIndex) + 
			              ", email = " + c.getString(emailColIndex));*/
			          str += "ID = " + c.getInt(idColIndex) + 
				            ", Date = " + c.getString(nameColIndex) + 
				            ", Value = " + c.getString(emailColIndex) + "\n";
			        } while (c.moveToNext());
			      } else
		   Log.d(LOG_TAG, "0 rows");
		c.close();
		dbHelper.close();
		return str;
	}
	
	public GraphViewData[] readDataForChart(){
		
	      Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
	      GraphViewData[] a = new GraphViewData[c.getCount()];
	      if (c.moveToFirst()) {
	        int emailColIndex = c.getColumnIndex(COLUMN_VALUE);
	        int i=0;
	        do {
	        	a[i++] = new GraphViewData(i, c.getDouble(emailColIndex)); // We got new data!
	        } while (c.moveToNext());
	      } else
		c.close();
		dbHelper.close();
		return a;
	}

}
