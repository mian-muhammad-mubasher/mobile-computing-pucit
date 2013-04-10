package pk.edu.pucit.mc.menudemo;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;

@SuppressLint("NewApi")
public class BasicMenuActivity extends MySharedCodeActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic_menu);
	}
	
	public void showPopUp(View v){
		PopupMenu pm = new PopupMenu(this, v);
		MenuInflater mi = pm.getMenuInflater();
		mi.inflate(R.menu.basic_menu, pm.getMenu());
		pm.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				return onOptionsItemSelected(item);
			}
		});
		pm.show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.basic_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

}
