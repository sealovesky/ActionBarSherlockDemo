package com.example.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.actionbarsherlockdemo.R;
import com.example.data.SimpleObject;



public class SimpleObjectAdapter extends BaseAdapter {
	
	ArrayList<SimpleObject> mObjects;
	LayoutInflater mInflater;
	
	//----------------------------
	private class SimpleObjectRow{
		TextView txtProductName;
		TextView txtProductPrice;
		RatingBar ratingBarProductRating;
		ImageView imgSpecialDeal;
	}
	
	
	public SimpleObjectAdapter(Context context, ArrayList<SimpleObject> objects){
		mObjects = objects;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mObjects.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mObjects.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		SimpleObjectRow theRow;
		
		// If ConvertView is null
		if(convertView == null){
			
			// Initialize a new SimpleObjectRow
			theRow = new SimpleObjectRow();
			
			// Inflate the UI from the XML Resource
			convertView = mInflater.inflate(R.layout.simple_object_item, null);
			
			theRow.txtProductName = (TextView) convertView.findViewById(R.id.txtProductName);
			theRow.txtProductPrice = (TextView) convertView.findViewById(R.id.txtProductPrice);
			theRow.imgSpecialDeal = (ImageView) convertView.findViewById(R.id.imgAbout);
			theRow.ratingBarProductRating = (RatingBar) convertView.findViewById(R.id.ratingBarProductRating);
			
			convertView.setTag(theRow);
		}else{
			theRow = (SimpleObjectRow) convertView.getTag();
		}
		
		// Update the UI
		theRow.txtProductName.setText(mObjects.get(position).getProductName());
		theRow.txtProductPrice.setText(mObjects.get(position).getProductPrice());
		theRow.ratingBarProductRating.setRating(mObjects.get(position).getRating());
		theRow.ratingBarProductRating.setEnabled(false);
		
		// See if its a daily deal
		if(mObjects.get(position).isDailyDeal()){
			theRow.imgSpecialDeal.setVisibility(View.VISIBLE);
		}else{
			theRow.imgSpecialDeal.setVisibility(View.GONE);
		}
		
		return convertView;
	}

}
