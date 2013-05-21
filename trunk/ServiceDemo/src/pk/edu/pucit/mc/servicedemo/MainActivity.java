package pk.edu.pucit.mc.servicedemo;

import pk.edu.pucit.mc.servicedemo.MyBoundService.LocalBinder;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("HandlerLeak")
public class MainActivity extends Activity {

	
	private MyBoundService mdbs = null;
	
	private ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			mdbs = null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			LocalBinder localBinder = (LocalBinder) service;
			mdbs = localBinder.getService();
		}
	}; 
	
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			String introduction = (String)msg.obj;
			TextView tv = (TextView)findViewById(R.id.my_text_view);
			tv.setText(introduction);
		}
	};
	
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

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Intent i = new Intent(this, MyBoundService.class);
		bindService(i, conn, Context.BIND_AUTO_CREATE);
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		unbindService(conn);
	}
	
	public void onClick(View v){
//		TextView tv = (TextView)findViewById(R.id.my_text_view);
//		tv.setText(Utils.getAsStringFromURL("http://localhost:8080/introduction"));
		Intent intent = null;
		if (v.getId()==R.id.my_downloader_service_button){
			intent = new Intent(this, MyDownloaderService.class);
		}else if(v.getId()==R.id.my_downloader_intent_service_button){
			intent = new Intent(this, MyDownloaderIntentService.class);
		}
		intent.putExtra(getResources().getString(R.string.url), "http://172.16.8.13:8080/introduction");
		intent.putExtra(getResources().getString(R.string.messenger), new Messenger(mHandler));
		startService(intent);
	}
	
	public void useBoundService(View v){
		TextView tv = (TextView)findViewById(R.id.my_text_view);
		if (mdbs!=null){			
			tv.setText(String.valueOf(mdbs.aVeryComplexAlgorithem()));
		}else{
			Toast.makeText(this, "Service not connected yet", Toast.LENGTH_SHORT).show();
		}
	}

	public void onClickClear(View v){
		TextView tv = (TextView)findViewById(R.id.my_text_view);
		tv.setText("");
	}
	
}
