package pk.edu.pucit.mc.surfaceviewdemo;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

@SuppressLint("UseSparseArrays")
public class MainActivity extends Activity {

	
	private static Map<Integer, Class<? extends Activity>> map 
	= new HashMap<Integer, Class<? extends Activity>>();
	
	static{
		map.put(R.id.clock, ClockActivity.class);
		map.put(R.id.ping_pong, PingPongActivity.class);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void click(View v){
		startActivity(
				new Intent(this, map.get(v.getId()))
		);
	}

}
