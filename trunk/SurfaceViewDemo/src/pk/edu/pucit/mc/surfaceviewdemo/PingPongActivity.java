package pk.edu.pucit.mc.surfaceviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PingPongActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ping_pong);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ping_pong, menu);
		return true;
	}

}
