package pk.edu.pucit.mc.webserviceconsumerservicedemo;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class FetchURLService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
		final Intent i = intent; 
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Messenger m = (Messenger)i.getExtras().get("m");
				String url = i.getStringExtra("url");
				InputStream html = Utils.downloadFromURL(url);
				Message msg = Message.obtain();
				try {
					msg.obj = new CityInfoServiceXMLParser().parse(html);
				} catch (XmlPullParserException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					m.send(msg);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});

		t.start();
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	private void aLongRunningMethod(){
		while(true);
	}
	
}
