package pk.edu.pucit.mc.menudemo;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

@SuppressLint("NewApi")
public class BasicMenuActivity extends Activity {

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
	
	public boolean onOptionsItemSelected (MenuItem item){
		switch (item.getItemId()) {

		case R.id.menu1:
//			Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
			return true;
		
		case R.id.menu2:
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
			return true;
			
		case R.id.menu3:
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
			return true;
			
		case R.id.menu4:
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
			return true;
			
		case R.id.sub_menu1:
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
			return true;

		case R.id.sub_menu2:
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
			return true;
		
		case R.id.sub_menu3:
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
			return true;
			
		case R.id.sub_menu4:
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
			return true;
			
		case R.id.close:
			finish();
			return true;
		
		default:
			return onOptionsItemSelected(item);
		}
		
	}

}
