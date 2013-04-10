package pk.edu.pucit.mc.menudemo;

import android.app.Activity;
import android.view.MenuItem;
import android.widget.Toast;

public class MySharedCodeActivity extends Activity {

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
