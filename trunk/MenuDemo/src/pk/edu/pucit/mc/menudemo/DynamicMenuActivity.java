package pk.edu.pucit.mc.menudemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DynamicMenuActivity extends Activity {

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

}
