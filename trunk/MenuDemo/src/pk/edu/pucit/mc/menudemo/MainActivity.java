package pk.edu.pucit.mc.menudemo;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

@SuppressLint("UseSparseArrays")
public class MainActivity extends Activity {

	static private Map<Integer, Class<? extends Activity>> ACTIVITY_MAP = null;
	
	static{
		ACTIVITY_MAP = new HashMap<Integer, Class<? extends Activity>>();
		ACTIVITY_MAP.put(R.id.basic_menu_button, BasicMenuActivity.class);
		ACTIVITY_MAP.put(R.id.context_menu_button, ContextMenuActivity.class);
		ACTIVITY_MAP.put(R.id.context_action_bar_button, ContextActionBarActivity.class);
		ACTIVITY_MAP.put(R.id.dynamic_menu_button, DynamicMenuActivity.class);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onButtonClick(View v){
		startActivity(
				new Intent(this, 
						ACTIVITY_MAP.get(v.getId())));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

}
