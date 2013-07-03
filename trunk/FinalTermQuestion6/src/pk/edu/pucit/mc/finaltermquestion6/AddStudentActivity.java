package pk.edu.pucit.mc.finaltermquestion6;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class AddStudentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_student);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_student, menu);
		return true;
	}
	
	public void save(View v){
		String rollNumber = ((EditText)findViewById(R.id.rollEditText)).getText().toString();
		String name = ((EditText)findViewById(R.id.nameEditText)).getText().toString();
		float cgpa = Float.parseFloat(((EditText)findViewById(R.id.cgpaEditText)).getText().toString());
		ContentValues values = new ContentValues();
		values.put(CMSDatabaseContract.tables.Student._ID, rollNumber);
		values.put(CMSDatabaseContract.tables.Student.ROLL_NUMBER, rollNumber);
		values.put(CMSDatabaseContract.tables.Student.NAME, name);
		values.put(CMSDatabaseContract.tables.Student.CGPA, cgpa);
		String authority =  getResources().getString(R.string.content_provider_authority);
		Uri uri = Uri.parse("content://"+authority+"/"+CMSDatabaseContract.tables.Student.TABLE_NAME);
		getContentResolver().insert(uri, values);
		finish();
	}

}
