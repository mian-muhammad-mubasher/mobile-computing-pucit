package pk.edu.pucit.mc.menudemo;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContextMenuActivity extends MySharedCodeActivity {

	public static String colors [] = new  String[]{
		"red",
		"green",
		"blue",
		"cyan",
		"black",
		"gray",
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_context_menu);
		ListView lv = (ListView) findViewById(R.id.my_list_view);
		ArrayAdapter<String> aa = new ArrayAdapter<String>
		(this, android.R.layout.simple_list_item_1, android.R.id.text1, colors);
		lv.setAdapter(aa);
		registerForContextMenu(lv);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.basic_menu, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.context_menu, menu);
		return true;
	}

}
