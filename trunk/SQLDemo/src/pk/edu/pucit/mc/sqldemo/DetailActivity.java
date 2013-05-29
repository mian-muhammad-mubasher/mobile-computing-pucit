package pk.edu.pucit.mc.sqldemo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		String rollNumber = getIntent().getStringExtra(getResources().getString(R.string.student_rollnumber)).toString();
		SQLiteDatabase db = new MySQLiteOpenHelper(this).getReadableDatabase();
		String table = SQLDemoContract.tables.StudentEntry.TABLE_NAME;
		String [] columns = {SQLDemoContract.tables.StudentEntry._ID, 
				SQLDemoContract.tables.StudentEntry.COLUMN_NAME_ROLL_NUMBER, 
				SQLDemoContract.tables.StudentEntry.COLUMN_NAME_NAME,
				SQLDemoContract.tables.StudentEntry.COLUMN_NAME_CGPA
				};
		String selection = SQLDemoContract.tables.StudentEntry._ID+"=?";
		String [] selectionArgs = {rollNumber};
		String groupBy = null;
		String having = null;
		String orderBy = null;
		Cursor c = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
		c.moveToFirst();
		((TextView)findViewById(R.id.student_rollnumber))
		.setText(c.getString(
				c.getColumnIndex(SQLDemoContract.tables.StudentEntry.COLUMN_NAME_ROLL_NUMBER)
				));
		((TextView)findViewById(R.id.student_name))
		.setText(c.getString(
				c.getColumnIndex(SQLDemoContract.tables.StudentEntry.COLUMN_NAME_NAME)
				));
		((TextView)findViewById(R.id.student_cgpa))
		.setText(Float.toString(c.getFloat(
				c.getColumnIndex(SQLDemoContract.tables.StudentEntry.COLUMN_NAME_CGPA)
				)));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

}
