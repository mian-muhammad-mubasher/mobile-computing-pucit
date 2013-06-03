package pk.edu.pucit.mc.contentproviderdemo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

	
	private MySQLiteOpenHelper mySQLiteOpenHelper = null;
	
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		mySQLiteOpenHelper = new MySQLiteOpenHelper(getContext());
		return false;
	}
	
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		// TODO Auto-generated method stub
		String table = SQLDemoContract.tables.StudentEntry.TABLE_NAME;
		ContentValues values = arg1;
		mySQLiteOpenHelper.getWritableDatabase().
		insert(table, null, values);
		return null;
	}

	@Override
	public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3,
			String arg4) {
		// TODO Auto-generated method stub
		String table = SQLDemoContract.tables.StudentEntry.TABLE_NAME;
		String [] columns = arg1;
		String selection = arg2;
		String [] selectionArgs = arg3;
		String orderBy = arg4;
		
		Cursor c = mySQLiteOpenHelper.getReadableDatabase().query
				(table, columns, selection, selectionArgs, null, null, orderBy); 
		return c;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
