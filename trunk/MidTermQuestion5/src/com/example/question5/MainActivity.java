package com.example.question5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	private String [] color = {"RED", "GREEN", "BLUE", "WHITE", "BLACK"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// find list view and attach add custom adapter with it.
		((ListView)findViewById(R.id.my_list_view)).setAdapter(new MyAdaptor(this, this.color));
	}

}
