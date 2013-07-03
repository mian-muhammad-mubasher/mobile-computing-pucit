package pk.edu.pucit.mc.finaltermquestion6;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;

public class ShowStudentsActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_students);
        String table = CMSDatabaseContract.tables.Student.TABLE_NAME;
        String [] columns = {CMSDatabaseContract.tables.Student._ID, CMSDatabaseContract.tables.Student.ROLL_NUMBER};
        String selection = null;
        String [] selectionArgs = null;
        String orderBy = null;
        String authority = getResources().getString(R.string.content_provider_authority);
        Uri uri = Uri.parse("content://"+authority+"/"+table);
        Cursor c = getContentResolver().query(uri, columns, selection, selectionArgs, orderBy);
        int [] to = {android.R.id.text1};
        String [] from = { CMSDatabaseContract.tables.Student.ROLL_NUMBER};
        SimpleCursorAdapter sca = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, c, from, to, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        setListAdapter(sca);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_students, menu);
		return true;
	}

}
