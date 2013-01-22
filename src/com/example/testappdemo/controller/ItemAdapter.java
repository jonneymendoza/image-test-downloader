/**
 * Copyright Monitise
 */
package com.example.testappdemo.controller;

import java.util.List;

import com.example.testappdemo.R;
import com.example.testappdemo.model.ItemTest;
import com.example.testappdemo.util.ImageLoader;
import com.example.testappdemo.util.ImageLoader.ImageLoaderListener;

import android.content.ClipData.Item;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author RichardsJ
 */
public class ItemAdapter extends BaseAdapter {

	private Context context;
	private List<ItemTest> list;
	private ImageLoader imageLoader;
	private Bitmap imageThumb;
	private ListView listview;

	public ItemAdapter(Context context, List<ItemTest> list, ListView listView) {
		this.context = context;
		this.list = list;
		this.listview = listView;
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ItemTestViewHolder holder;


		if (convertView == null) {
			convertView = View.inflate(context, R.layout.list_item, null);
			holder = new ItemTestViewHolder();

			holder.title = (TextView)convertView.findViewById(R.id.textViewTitle);
			holder.percent = (TextView)convertView.findViewById(R.id.textViewPercent);

			convertView.setTag(holder);

		} else {
			holder = (ItemTestViewHolder)convertView.getTag();

		}

		String url = list.get(position).getImage();

		ImageView image = (ImageView)convertView.findViewById(R.id.imageViewThumb);
		image.setTag(url);

		holder.title.setText(list.get(position).getTitle());
		holder.percent.setText(Integer.toString(list.get(position).getPercent()));

		imageLoader = new ImageLoader(new ImageLoaderListener() {
			@Override
			public void onImageLoaded(Bitmap image, String url) {
				imageThumb = image;
				ImageView imageByTag = (ImageView)listview.findViewWithTag(url);
				if (imageThumb != null && imageByTag != null) {
					imageByTag.setImageBitmap(imageThumb);
				}

			}
		});

		imageLoader.getThumbImage(url);


		return convertView;
	}

	static class ItemTestViewHolder {
		ImageView image;
		TextView title;
		TextView percent;
	}

}
