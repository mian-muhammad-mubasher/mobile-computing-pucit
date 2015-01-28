package pk.edu.pucit.mc.webserviceconsumerservicedemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

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
	
}
