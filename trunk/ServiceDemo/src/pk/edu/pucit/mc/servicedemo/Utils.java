package pk.edu.pucit.mc.servicedemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class Utils {
	
	public static InputStream downloadFromURL(String urlString){
		InputStream retval = null;
		try {
			URL url = new URL(urlString);
			URLConnection ucon = url.openConnection();
			retval = ucon.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retval;
	}
	
	public static String getAsStringFromURL(String urlString){
		String retval = "";
		InputStream is = null;
		if ((is = downloadFromURL(urlString)) != null){
			try {
				retval = new String(IOUtils.toByteArray(is));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return retval;
	}
	
	public static void download(Context c, Intent i){
		String urlString = i.getStringExtra(c.getResources().getString(R.string.url));
		Messenger messenger = (Messenger)i.getExtras().get(c.getResources().getString(R.string.messenger));
		String introduction = Utils.getAsStringFromURL(urlString);
		Message message = Message.obtain();
		message.obj = introduction;
		try {
			messenger.send(message);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
