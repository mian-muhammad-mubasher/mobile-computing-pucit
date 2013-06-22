package com.example.question5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdaptor extends BaseAdapter {

	private Context mContext;
	private String [] color;
	
	public MyAdaptor(Context mContext, String [] color) {
		// TODO Auto-generated constructor stub
		// initiate class level variables mContext and color
		this.mContext = mContext;
		this.color = color;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		// return length of the underlying data
		return this.color.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// return a TextView with appropriate text using position parameter.
		// hint: to make a TextView context is needed to be passed in its constructor.
		TextView tv = (TextView)convertView;
		if(tv == null){
			tv = new TextView(this.mContext);
		}
		tv.setText(this.color[position]);
		return tv;
	}

}
