package pk.edu.pucit.mc.sqldemo;

import android.annotation.TargetApi;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SQLiteDatabase db = new MySQLiteOpenHelper(this).getReadableDatabase();
		String table = SQLDemoContract.tables.StudentEntry.TABLE_NAME;
		String [] columns = {SQLDemoContract.tables.StudentEntry._ID, SQLDemoContract.tables.StudentEntry.COLUMN_NAME_ROLL_NUMBER};
		String selection = null;
		String [] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = null;
		Cursor c = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
		int [] to = {android.R.id.text1};
		String [] from = { SQLDemoContract.tables.StudentEntry.COLUMN_NAME_ROLL_NUMBER};
		SimpleCursorAdapter sca = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, c, from, to, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		setListAdapter(sca);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		boolean retval = super.onOptionsItemSelected(item);
		if (item.getItemId() == R.id.add){
			startActivity(
					new Intent(this, AddStudentActivity.class)
					);
			retval = true;
		}
		return retval;
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		TextView tv = (TextView) v;
		String rollNumber = tv.getText().toString();
		Intent i = new Intent(this, DetailActivity.class);
		i.putExtra(getResources().getString(R.string.student_rollnumber), rollNumber);
		startActivity(i);
	}
	
}
