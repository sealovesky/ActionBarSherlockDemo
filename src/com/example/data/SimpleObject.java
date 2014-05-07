package com.example.data;

import android.os.Parcel;
import android.os.Parcelable;



public class SimpleObject implements Parcelable{
	
	private String productName = null;
	private String productPrice = null;
	private boolean dailyDeal = false;
	private int rating = -1;
	
	public SimpleObject(){}
	
	public SimpleObject(Parcel source){
		
		productName = source.readString();
		productPrice = source.readString();
		dailyDeal = source.readByte() != 0;
		
	}
	

	// --------------------------------------------------------
	// Setters and getters
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public void setDailyDeal(boolean dailyDeal) {
		this.dailyDeal = dailyDeal;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getProductName() {
		return productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public boolean isDailyDeal() {
		return dailyDeal;
	}

	public int getRating() {
		return rating;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// Write Data to Parcel
		dest.writeString(productName);
		dest.writeString(productPrice);
		dest.writeByte((byte) (dailyDeal ? 1 : 0));
		dest.writeInt(rating);
		
	}
	
	// -----------------------------------------------------------------------
	// Parcelable.Creator
	
	/**
	 * This Creator is used to Marshal and unMarshal this object when the activity
	 * is recreated from a screen rotation, or restore state.
	 */
	public static final Parcelable.Creator<SimpleObject> CREATOR = new Parcelable.Creator<SimpleObject>(){
		@Override 
		public SimpleObject createFromParcel(Parcel source){
			return new SimpleObject(source);
		}

		@Override
		public SimpleObject[] newArray(int size) {

			return new SimpleObject[size];
		}
	};
	
	
}
