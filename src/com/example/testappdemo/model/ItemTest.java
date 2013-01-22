/**
 * Copyright Monitise
 */
package com.example.testappdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author RichardsJ
 *
 */
public class ItemTest implements Parcelable {

	private String serverId;

	private String image;

	private String title;

	private int percent;

	private String description;

	/**
	 * @param serverId
	 * @param image
	 * @param title
	 * @param percent
	 * @param description
	 */
	public ItemTest(String serverId, String image, String title, int percent, String description) {
		this.serverId = serverId;
		this.image = image;
		this.title = title;
		this.percent = percent;
		this.description = description;
	}

	private ItemTest(Parcel in) {
		title = in.readString();
		description = in.readString();
		image = in.readString();
		serverId = in.readString();
		percent = in.readInt();

	}

	public ItemTest() {

	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * @see android.os.Parcelable#describeContents()
	 */
	@Override
	public int describeContents() {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(title);
		dest.writeString(description);
		dest.writeString(image);
		dest.writeString(serverId);
		dest.writeInt(percent);

	}

	public static final Parcelable.Creator<ItemTest> CREATOR = new Parcelable.Creator<ItemTest>() {

		@Override
		public ItemTest createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new ItemTest(source);
		}

		@Override
		public ItemTest[] newArray(int size) {
			// TODO Auto-generated method stub
			return new ItemTest[size];
		}

	};

}
