package pk.edu.pucit.mc.listviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_list);
		List<Map<String, String>> data =
		        new ArrayList<Map<String,String>>();
	    for( int i = 1; i <= 50; i++ ){
	        Map<String, String> item =
	            new HashMap<String, String>();
	        item.put( "name", String.format( "Item %d", i ) );
	        data.add( item );
	    }
	 
	    String[] from = { "name" };
	    int[] to = { android.R.id.text1 };
	     
	    SimpleAdapter adapter = new SimpleAdapter( this, data,
	        android.R.layout.simple_list_item_1, from, to );
	    setListAdapter( adapter );
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	    TextView textView = (TextView) v.findViewById( android.R.id.text1 );
	    toast( (String) textView.getText() );
	}
	
	private void toast( String text )
	{
	    Toast.makeText( this,
	        String.format( "Item clicked: %s", text ), Toast.LENGTH_SHORT )
	        .show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_list, menu);
		return true;
	}

}
