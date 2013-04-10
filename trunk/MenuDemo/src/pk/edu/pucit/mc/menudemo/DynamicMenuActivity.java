package pk.edu.pucit.mc.menudemo;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

@SuppressLint("NewApi")
public class DynamicMenuActivity extends Activity {

	private boolean firstTimeSkip = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dynamic_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dynamic_menu, menu);
		return true;
	}
	
	public void onTextViewClick(View v){
		Toast.makeText(this, "Text View Clicked!", Toast.LENGTH_SHORT).show();
		invalidateOptionsMenu();
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		if (firstTimeSkip){			
			menu.add(Menu.NONE, R.id.dynamic_menu1, 1, "Dynamic Menu 1")
			.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
			menu.add(Menu.NONE, R.id.dynamic_menu2, 1, "Dynamic Menu 2")
			.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);;
			menu.add(Menu.NONE, R.id.dynamic_menu3, 1, "Dynamic Menu 3")
			.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
			menu.add(Menu.NONE, R.id.dynamic_menu4, 1, "Dynamic Menu 4")
			.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
			return true;
		}else{
			firstTimeSkip = true;
			return super.onPrepareOptionsMenu(menu);
		}
	}

}
