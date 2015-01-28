package pk.edu.pucit.mc.webserviceconsumerservicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			CityInfoDTO [] data = (CityInfoDTO [])msg.obj;
			ListView lv = (ListView)findViewById(R.id.lv);
			lv.setAdapter(new ArrayAdapter<CityInfoDTO>(MainActivity.this, R.layout.city_info_layout, data));
		}
	};
	/*
	 */
	
	public void onClick (View v){
	
		Messenger m = new Messenger(mHandler);
		Intent i = new Intent(this, FetchURLService.class);
		i.putExtra("url", "http://10.0.2.2:8080/CityInfoService.jsp?cc=PAK");
		i.putExtra("m", m);
		startService(i);
		
		
		
		
		
		
		
		
		
		
//		Intent i = new Intent(this, FetchURLService.class);
//		startService(i);
//		String html = "<h1>Mobile Computing</h1>";
//		wv.loadUrl("http://10.0.2.2:8080");
		
//		Intent i = new Intent(this, FetchURLService.class);
//		startService(i);

//		Intent i = new Intent(this, CityInfoService.class);
		
		
//		Intent i = new Intent(this, CityInfoService.class);
//		i.putExtra("m", new Messenger(mHandler));
//		startService(i);

		
//		String html = Utils.getAsStringFromURL("http://10.0.2.2:8080");
//		wv.loadData(html, "text/html", null);
	}
}
