/**
 * Copyright Monitise
 */
package com.example.testappdemo.views;

import com.example.testappdemo.R;
import com.example.testappdemo.model.ItemTest;
import com.example.testappdemo.util.ImageLoader;
import com.example.testappdemo.util.ImageLoader.ImageLoaderListener;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author RichardsJ
 */
public class DetailActivity extends Activity {

	private ItemTest item;

	private TextView titleText;

	private TextView description;

	private ImageView imageItem;

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_view);

		initialiseViews();
	}

	private void initialiseViews() {

		item = getIntent().getParcelableExtra("item");

		titleText = (TextView)findViewById(R.id.title_text);
		description = (TextView)findViewById(R.id.description_text);
		imageItem = (ImageView)findViewById(R.id.image);

		titleText.setText(item.getTitle());
		description.setText(item.getDescription());

		new ImageLoader(new ImageLoaderListener() {

			@Override
			public void onImageLoaded(Bitmap image, String url) {

				imageItem.setImageBitmap(image);
			}
		}).getOriginalImage(item.getImage());

	}

}
