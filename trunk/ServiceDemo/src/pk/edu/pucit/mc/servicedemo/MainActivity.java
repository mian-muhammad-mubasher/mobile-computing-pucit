package pk.edu.pucit.mc.servicedemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

@SuppressLint("HandlerLeak")
public class MainActivity extends Activity {

	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			String introduction = (String)msg.obj;
			TextView tv = (TextView)findViewById(R.id.my_text_view);
			tv.setText(introduction);
			findViewById(R.id.my_button).setEnabled(true);
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

	public void onCLick(View v){
		v.setEnabled(false);
//		tv.setText(Utils.getAsStringFromURL("http://localhost:8080/introduction"));
		Intent intent = new Intent(this, MyDownloaderService.class);
		intent.putExtra(Constants.IntentBundleKeys.URL, "http://172.16.8.13:8080/introduction");
		intent.putExtra(Constants.IntentBundleKeys.MESSENGER, new Messenger(mHandler));
		startService(intent);
	}
	
}
