package pk.edu.pucit.mc.finaltermquestion5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CMSSQLiteOpenHelper extends SQLiteOpenHelper {

	private static final String FILE_NAME = "CMSDatabase.db";
	private static final int VERSION = 1;
	
	public CMSSQLiteOpenHelper(Context context) {
		super(context, FILE_NAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CMSDatabaseContract.commands.Student.CREATE_TABLE);
		db.execSQL(CMSDatabaseContract.commands.Teacher.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
