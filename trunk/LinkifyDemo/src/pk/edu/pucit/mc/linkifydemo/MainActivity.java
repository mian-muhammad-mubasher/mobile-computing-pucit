package pk.edu.pucit.mc.linkifydemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try{			
			InputStream inputStream = getAssets().open("welcome_note");
			String welcomeNote = readAll(inputStream);
			TextView myTextView = (TextView)findViewById(R.id.my_text_view);
			myTextView.setText(welcomeNote);
			Linkify.addLinks(myTextView, Linkify.ALL);
			Pattern userPattern = Pattern.compile("\\B@\\w+");
			Linkify.addLinks(myTextView, userPattern, "myuser://");
		}catch (IOException e) {
			Log.e("custom_log", "unable to open welcome_note", e);
		}
	}
	
	public static String readAll(InputStream inputStream) throws IOException{
		byte [] byteArray = IOUtils.toByteArray(inputStream);
		return new String(byteArray);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void fireHttpIntent(View v){
		startActivity(
		new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
		);
	}
	
	public void fireMyUserIntent(View v){
		startActivity(
		new Intent(Intent.ACTION_VIEW, Uri.parse("myuser://@mmmubasher"))
		);
	}

}
