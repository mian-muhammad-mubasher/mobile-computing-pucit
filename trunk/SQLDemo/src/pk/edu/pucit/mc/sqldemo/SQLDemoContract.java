package pk.edu.pucit.mc.sqldemo;

import android.provider.BaseColumns;

public abstract class SQLDemoContract {
	
	public static abstract class tables{
		public static abstract class StudentEntry implements BaseColumns {
			public static final String TABLE_NAME = "student";
			public static final String COLUMN_NAME_ROLL_NUMBER = "roll_number";
			public static final String COLUMN_NAME_NAME = "name";
			public static final String COLUMN_NAME_CGPA = "cgpa";
		}		
	}
	
	public static abstract class commands{
		private static final String TEXT_TYPE = " TEXT";
		private static final String FLOAT_TYPE = " REAL";
		private static final String COMMA_SEP = ",";
		public abstract class StudentEntry{			
			public static final String SQL_CREATE_ENTRIES =
					"CREATE TABLE " + SQLDemoContract.tables.StudentEntry.TABLE_NAME + " ( " +
							SQLDemoContract.tables.StudentEntry._ID + " TEXT PRIMARY KEY," +
							SQLDemoContract.tables.StudentEntry.COLUMN_NAME_ROLL_NUMBER + TEXT_TYPE + COMMA_SEP +
							SQLDemoContract.tables.StudentEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
							SQLDemoContract.tables.StudentEntry.COLUMN_NAME_CGPA + FLOAT_TYPE +
							" )";
		}
	}
}
