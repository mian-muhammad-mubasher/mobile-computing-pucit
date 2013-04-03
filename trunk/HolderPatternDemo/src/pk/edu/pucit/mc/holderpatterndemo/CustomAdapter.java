package pk.edu.pucit.mc.holderpatterndemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	private Activity context;
	
	private class ViewHolder{
		public ImageView imageView;
		public TextView textView;
	}
	
	public CustomAdapter(Activity context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mThumbIds.length;
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
		View v = convertView;
		if(v == null){			
			LayoutInflater layoutInflater = context.getLayoutInflater();
			v = layoutInflater.inflate(R.layout.custom_list_view, null);
			ImageView imageView = (ImageView)v.findViewById(R.id.my_image_view);
			TextView textView = (TextView)v.findViewById(R.id.my_text_view);
			ViewHolder vh = new ViewHolder();
			vh.imageView = imageView;
			vh.textView = textView;
			v.setTag(vh);
		}
		ViewHolder vh = (ViewHolder) v.getTag();
		ImageView imageView = vh.imageView;
		TextView textView = vh.textView;
		imageView.setImageResource(mThumbIds[position]);
		textView.setText(mThumbDescriptions[position%mThumbDescriptions.length]);
		return v;
	}
	
	private String[] mThumbDescriptions = {
		"Doggy 1",
		"Doggy 2",
		"Doggy 3",
		"Doggy 4",
		"Doggy 5",
		"Doggy 6",
		"Doggy 7",
		"Doggy 8",
	};
	
	private Integer[] mThumbIds = {
			R.drawable.sample_0, R.drawable.sample_1,
			R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };

}
