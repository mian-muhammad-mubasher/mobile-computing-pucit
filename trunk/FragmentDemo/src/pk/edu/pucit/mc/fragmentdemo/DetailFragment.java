package pk.edu.pucit.mc.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

	private int index = -1; 
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		TextView tv = new TextView(getActivity());
		tv.setId(R.id.detail_text_view);
		String description = "No movie selected!";
		description = MainActivity.movies[index].getDescription();
		tv.setText(description);
		return tv;
	}
	
	public void onMovieSelect(int position){
		TextView tv = (TextView) getView();
		tv.setText(MainActivity.movies[position].getDescription());
	}
	
}
