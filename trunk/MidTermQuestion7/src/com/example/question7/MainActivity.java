package com.example.question7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void send(View v){
		Intent i = new Intent(this, DetailActivity.class);
		EditText et = (EditText)findViewById(R.id.my_edit_text);
		i.putExtra("msg", et.getText());
		startActivity(i);
	}

}
