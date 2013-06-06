package pk.edu.pucit.mc.surfaceviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ClockActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clock);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.clock, menu);
		return true;
	}

}
