package pk.edu.pucit.mc.finaltermquestion8;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	DegreeStatisticsEngine engine;
	EngineServiceConnection conn = new EngineServiceConnection(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Intent i = new Intent(this, StudentStatisticsService.class);
		bindService(i, conn, Context.BIND_AUTO_CREATE);
	}
	
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		unbindService(conn);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void showStatistics(View v) {
		if (engine!=null){
			((TextView)findViewById(R.id.median)).setText(Float.toString(engine.getMedian()));
			((TextView)findViewById(R.id.mode)).setText(Float.toString(engine.getMode()));
			((TextView)findViewById(R.id.range)).setText(Float.toString(engine.getRange()));			
		}else{
			Toast.makeText(this, "Engine not intialized", Toast.LENGTH_SHORT).show();
		}
	}

}
