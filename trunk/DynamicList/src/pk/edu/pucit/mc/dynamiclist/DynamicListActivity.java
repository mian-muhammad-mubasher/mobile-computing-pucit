package pk.edu.pucit.mc.dynamiclist;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DynamicListActivity extends ListActivity {
	
	private List<String> data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dynamic_list);
		
		 data =
		        new ArrayList<String>();
	    for( int i = 1; i <= 50; i++ ){
	        data.add( String.format( "Item %d", i ) );
	    }
	    
	    ArrayAdapter<String> mAdapter = new ArrayAdapter<String>
	    (this, R.layout.custom_element, R.id.my_text_view, data);
	    
	    setListAdapter(mAdapter);
		
	}

	public void addItem(View v){ 
		ListView lv = (ListView)findViewById(android.R.id.list);
		data.add(""+(data.size()+1));
		ArrayAdapter<String> adapter = (ArrayAdapter<String>) lv.getAdapter();
		adapter.notifyDataSetChanged(); 
	}
	
	public void delItem(View v){
		ListView lv = (ListView)findViewById(android.R.id.list);
		data.remove(0);
		ArrayAdapter<String> adapter = (ArrayAdapter<String>) lv.getAdapter();
		adapter.notifyDataSetChanged(); 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dynamic_list, menu);
		return true;
	}

}
