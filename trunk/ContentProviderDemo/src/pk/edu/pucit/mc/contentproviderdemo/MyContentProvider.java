package pk.edu.pucit.mc.contentproviderdemo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

	
	private MySQLiteOpenHelper mySQLiteOpenHelper = null;
	private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	static{
		uriMatcher.addURI("pk.edu.pucit.mc.contentproviderdemo", 
				SQLDemoContract.tables.StudentEntry.TABLE_NAME, 0);
		uriMatcher.addURI("pk.edu.pucit.mc.contentproviderdemo", 
				SQLDemoContract.tables.StudentEntry.TABLE_NAME+"/*", 1);
	}
	
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		mySQLiteOpenHelper = new MySQLiteOpenHelper(getContext());
		return true;
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
		Uri uri = arg0;
		String table = null;
		String [] columns = arg1;
		String selection = arg2;
		String [] selectionArgs = arg3;
		String orderBy = arg4;
		
		switch (uriMatcher.match(uri)) {
		case 0:
			table = uri.getPathSegments().get(0);
			break;
		case 1:
			table = uri.getPathSegments().get(0);
			selection = SQLDemoContract.tables.StudentEntry._ID+"=?";
			selectionArgs = new String [] {uri.getLastPathSegment()};
			break;
		default:
			return null;
		}
		
		
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
