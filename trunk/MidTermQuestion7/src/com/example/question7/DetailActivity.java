package com.example.question7;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		// Assume that activity_detail.xml has TextView with id my_text_view
		// get text from intent and set that text in TextView
		String msg = getIntent().getStringExtra("msg");
		((TextView)findViewById(R.id.my_text_view)).setText(msg);
	}
}
