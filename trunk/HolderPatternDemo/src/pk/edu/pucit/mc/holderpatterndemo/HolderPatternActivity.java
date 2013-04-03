package pk.edu.pucit.mc.holderpatterndemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class HolderPatternActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_holder_pattern);
		ListView listView = (ListView)findViewById(android.R.id.list);
		listView.setAdapter(new CustomAdapter(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.holder_pattern, menu);
		return true;
	}

}
