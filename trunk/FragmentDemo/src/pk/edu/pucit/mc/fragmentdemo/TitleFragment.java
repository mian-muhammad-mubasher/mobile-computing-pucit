package pk.edu.pucit.mc.fragmentdemo;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitleFragment extends ListFragment{
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setListAdapter(
				new ArrayAdapter<Movie>(
						getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, MainActivity.movies)
		);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Fragment df = getActivity().getFragmentManager().findFragmentById(R.id.detail_fragment);
		if(df != null){
			((MainActivity)getActivity()).onMovieSelect(position);
		}else{
			Intent i = new Intent(getActivity(), DetailActivity.class);
			i.putExtra("index", position);
			startActivity(i);
		}
	}
}
