package pk.edu.pucit.mc.webserviceconsumerservicedemo;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParserException;

import android.app.IntentService;
import android.content.Intent;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class CityInfoService extends IntentService {

	public CityInfoService() {
		super("CityInfoService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		InputStream is = Utils.downloadFromURL("http://10.0.2.2:8080/CityInfoService.jsp?cc=PAK");
		CityInfoServiceXMLParser xmlParser = new CityInfoServiceXMLParser();
		try {
			CityInfoDTO [] data = xmlParser.parse(is);
			Messenger m = (Messenger)intent.getExtras().get("m");
			Message msg = Message.obtain();
			msg.obj = data;
			try {
				m.send(msg);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
