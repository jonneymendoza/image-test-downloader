
package com.example.testappdemo.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author RichardsJ
 *
 */
public class TestItemSqlHelper extends SQLiteOpenHelper {

	private static TestItemSqlHelper mTestItemHelper;

	private static final String DATABASE_NAME = "testDB";
	private static final int DATABASE_VERSION = 1;
	private static final String CREATE_TABLE_SQL = "";

	/**
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	private TestItemSqlHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public static TestItemSqlHelper open(Context context){
		if(mTestItemHelper == null){
			mTestItemHelper = new TestItemSqlHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		return mTestItemHelper;
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(CREATE_TABLE_SQL);

	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


	}


}
