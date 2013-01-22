package com.example.testappdemo.views;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.testappdemo.R;
import com.example.testappdemo.R.layout;
import com.example.testappdemo.R.menu;
import com.example.testappdemo.controller.ItemAdapter;
import com.example.testappdemo.model.ItemTest;
import com.example.testappdemo.util.Server;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListActivity extends Activity implements OnItemClickListener {

	public static final String TAG = "ListActivity";
	private ListView listView;
	private List<ItemTest> list = new ArrayList<ItemTest>();
	private ItemAdapter adapter;
	private ProgressDialog progress;
	private Context mContext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		mContext = getApplicationContext();

		listView = (ListView)findViewById(R.id.list);

		adapter = new ItemAdapter(this, list, listView);

		listView.setAdapter(adapter);

		listView.setOnItemClickListener(this);

		new DownloadItemTask().execute();
	}

	class DownloadItemTask extends AsyncTask<Void, Void, List<ItemTest>> {


		List<ItemTest> downloadItems() {

			List<ItemTest> items = new ArrayList<ItemTest>();

			try {
				String response = Server.getItems();

				JSONArray jsonArray = new JSONArray(response);

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject json = jsonArray.getJSONObject(i);
					items.add(new ItemTest(json.getString("server_id"), json.getString("image_url"), json
							.getString("title"), Integer.parseInt(json.getString("percent")), json
							.getString("description")));
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.e(TAG, "DownloadItemTask exception", e);
			}
			return items;

		}

		/*
		 * (non-Javadoc)
		 * @see android.os.AsyncTask#onPreExecute()
		 */
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

			showLoadingDialog();
		}

		/*
		 * (non-Javadoc)
		 * @see android.os.AsyncTask#doInBackground(Params[])
		 */
		@Override
		protected List<ItemTest> doInBackground(Void... params) {
			// TODO Auto-generated method stub

			List<ItemTest> items = downloadItems();

			return items;
		}


		/*
		 * (non-Javadoc)
		 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
		 */
		@Override
		protected void onPostExecute(List<ItemTest> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			progress.dismiss();
			list = result;
			adapter = new ItemAdapter(mContext, result, listView);
			listView.setAdapter(adapter);
			listView.invalidate();
		}

	}

	private void showLoadingDialog() {
		progress = ProgressDialog.show(this, null, "Loading", true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_list, menu);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View,
	 * int, long)
	 */
	@Override
	public void onItemClick(AdapterView<?> parentView, View view, int position, long arg3) {
		Intent intent = new Intent(this, DetailActivity.class);
		intent.putExtra("item", list.get(position));
		startActivity(intent);

	}
}
