package pk.edu.pucit.mc.finaltermquestion5;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class CMSContentProvider extends ContentProvider {

	private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	private CMSSQLiteOpenHelper sqlite = null;
	private static final String AUTHORITY = "pk.edu.pucit.mc.finaltermquestion5";
	static{	
		uriMatcher.addURI(AUTHORITY, CMSDatabaseContract.tables.Teacher.TABLE_NAME, 0);
		uriMatcher.addURI(AUTHORITY, CMSDatabaseContract.tables.Student.TABLE_NAME, 1);
		uriMatcher.addURI(AUTHORITY, CMSDatabaseContract.tables.Teacher.TABLE_NAME+"/#", 2);
		uriMatcher.addURI(AUTHORITY, CMSDatabaseContract.tables.Student.TABLE_NAME+"/*", 3);	
	}
	
	private static class UriParserHelper{
		
		public String table;
		public String whereClause;
		public String [] whereArgs;
		
		static public UriParserHelper parseURI(Uri uri, String whereClause, String[] whereArgs){
			UriParserHelper retval = new UriParserHelper();
			retval.whereClause = whereClause;
			retval.whereArgs = whereArgs;
			switch (uriMatcher.match(uri)) {
			case 0:
				retval.table = CMSDatabaseContract.tables.Teacher.TABLE_NAME;
				break;
			case 1:
				retval.table = CMSDatabaseContract.tables.Student.TABLE_NAME;
				break;
			case 2:
				retval.table = CMSDatabaseContract.tables.Teacher.TABLE_NAME;
				retval.whereClause = CMSDatabaseContract.tables.Teacher._ID+"=?";
				retval.whereArgs = new String[]{uri.getLastPathSegment()};
				break;
			case 3:
				retval.table = CMSDatabaseContract.tables.Student.TABLE_NAME;
				retval.whereClause = CMSDatabaseContract.tables.Student._ID+"=?";
				retval.whereArgs = new String[]{uri.getLastPathSegment()};
				break;
				
			default:
				break;
			}
			return retval;
		}
	}
	
	@Override
	public int delete(Uri uri, String whereClause, String[] whereArgs) {
		// TODO Auto-generated method stub
		UriParserHelper helper = UriParserHelper.parseURI(uri, whereClause, whereArgs);
		String table = helper.table;
		whereClause = helper.whereClause;
		whereArgs = helper.whereArgs;
		SQLiteDatabase db  = sqlite.getReadableDatabase();
		if (table != null){
			return db.delete(table, whereClause, whereArgs);
		}else{			
			return 0;
		}
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		Uri retval = null;
		UriParserHelper helper = UriParserHelper.parseURI(uri, null, null);
		String table = helper.table;
		if (table != null){
			SQLiteDatabase db = sqlite.getWritableDatabase();
			long id = db.insert(table, null, values);
			if (table == CMSDatabaseContract.tables.Teacher.TABLE_NAME){
				retval = Uri.parse(AUTHORITY+"/"+table+"/"+id);
			}else if (table == CMSDatabaseContract.tables.Student.TABLE_NAME){				
				String rollNumber = values.getAsString(CMSDatabaseContract.tables.Student.ROLL_NUMBER);
				retval = Uri.parse(AUTHORITY+"/"+table+"/"+rollNumber);
			}
		}
		return retval;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		sqlite = new CMSSQLiteOpenHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		String [] columns = null;
		UriParserHelper helper = UriParserHelper.parseURI(uri, selection, selectionArgs);
		String table = helper.table;
		selection = helper.whereClause;
		selectionArgs = helper.whereArgs;
		SQLiteDatabase db = sqlite.getReadableDatabase();
		if (table == CMSDatabaseContract.tables.Teacher.TABLE_NAME){
			columns = new String[]{
				CMSDatabaseContract.tables.Teacher._ID,
				CMSDatabaseContract.tables.Teacher.NAME,
				CMSDatabaseContract.tables.Teacher.QUALIFICATION
			};
		}else if(table == CMSDatabaseContract.tables.Student.TABLE_NAME){
			columns = new String[]{
				CMSDatabaseContract.tables.Student._ID,
				CMSDatabaseContract.tables.Student.ROLL_NUMBER,
				CMSDatabaseContract.tables.Student.NAME,
				CMSDatabaseContract.tables.Student.CGPA
			};			
		}
		return db.query(table, columns, selection, selectionArgs, null, null, sortOrder);
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
