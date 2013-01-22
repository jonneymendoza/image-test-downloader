/**
 * Copyright Monitise
 */
package com.example.testappdemo.model;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author RichardsJ
 *
 */
public class ItemDataSource {

	private Context mContext;

	private TestItemSqlHelper sqlHelper;

	private SQLiteDatabase mDatabase;

	public ItemDataSource(Context context) {
		mContext = context;
		mDatabase = sqlHelper.open(mContext).getWritableDatabase();
	}

	public void saveAll() {

	}

	public List<ItemTest> getAll() {

		return null;
	}

	public ItemTest getItemDetails(int serverId) {

		return null;
	}

}
