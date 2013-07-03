package pk.edu.pucit.mc.finaltermquestion7;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class UserDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_detail);
		String authority = getResources().getString(R.string.content_provider_authority);
        String rollNumberPK = getIntent().getDataString().split("@")[1];
		Uri uri = Uri.parse("content://"+authority+"/"+CMSDatabaseContract.tables.Student.TABLE_NAME+"/"+rollNumberPK);
		Cursor c = getContentResolver().query(uri, null, null, null, null);
		c.moveToFirst();
		String rollNumber = c.getString(c.getColumnIndex(CMSDatabaseContract.tables.Student.ROLL_NUMBER));
		String name = c.getString(c.getColumnIndex(CMSDatabaseContract.tables.Student.NAME));
		float cgpa = c.getFloat(c.getColumnIndex(CMSDatabaseContract.tables.Student.CGPA));
        ((TextView)findViewById(R.id.rollNumberTextView)).setText(rollNumber);
        ((TextView)findViewById(R.id.nameTextView)).setText(name);
        ((TextView)findViewById(R.id.cgpaTextView)).setText(Float.toString(cgpa));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_detail, menu);
		return true;
	}

}
