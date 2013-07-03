package pk.edu.pucit.mc.finaltermquestion7;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

import android.app.Activity;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			String fileName = getResources().getString(R.string.linkify_description_file_path);
			InputStream is = getAssets().open(fileName);
			byte [] array = IOUtils.toByteArray(is);
			String description = new String(array);
			TextView descriptionTextView = (TextView) findViewById(R.id.description);
			descriptionTextView.setText(description);
			Pattern p = Pattern.compile("\\B@[a-z0-9]*");
			Linkify.addLinks(descriptionTextView, Linkify.ALL);
			String scheme = getResources().getString(R.string.user_scheme);
			Linkify.addLinks(descriptionTextView, p, scheme);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
