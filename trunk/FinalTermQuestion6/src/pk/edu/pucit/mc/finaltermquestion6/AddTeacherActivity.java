package pk.edu.pucit.mc.finaltermquestion6;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class AddTeacherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_teacher);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_teacher, menu);
		return true;
	}
	
	public void save(View v){
		String name = ((EditText)findViewById(R.id.nameEditText)).getText().toString();
		String qualification = ((EditText)findViewById(R.id.qualificationEditText)).getText().toString();
		ContentValues values = new ContentValues();
		values.put(CMSDatabaseContract.tables.Teacher.NAME, name);
		values.put(CMSDatabaseContract.tables.Teacher.QUALIFICATION, qualification);
		String authority = getResources().getString(R.string.content_provider_authority);
		Uri uri = Uri.parse("content://"+authority+"/"+CMSDatabaseContract.tables.Teacher.TABLE_NAME);
		getContentResolver().insert(uri, values);
		finish();
	}

}
