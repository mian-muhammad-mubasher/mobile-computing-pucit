package pk.edu.pucit.mc.finaltermquestion6;

import android.provider.BaseColumns;

public class CMSDatabaseContract extends Object{
	
	public static class tables{
		public static class Student implements BaseColumns{
			public static final String TABLE_NAME = "student";
			public static final String ROLL_NUMBER = "rollnumber";
			public static final String NAME = "name";
			public static final String CGPA= "cgpa";
		}
		public static class Teacher implements BaseColumns{
			public static final String TABLE_NAME = "teacher";
			public static final String NAME = "name";
			public static final String QUALIFICATION= "qualification";
		}
	}
	public static class commands{
		public static class Student{
			public static final String CREATE_TABLE = 
				"CREATE TABLE "+CMSDatabaseContract.tables.Student.TABLE_NAME+" ("+
				CMSDatabaseContract.tables.Student._ID + " TEXT PRIMARY KEY,"+
				CMSDatabaseContract.tables.Student.ROLL_NUMBER+" TEXT,"+
				CMSDatabaseContract.tables.Student.NAME+" TEXT,"+
				CMSDatabaseContract.tables.Student.CGPA+" REAL"+
				" )";
		}
		public static class Teacher{
			public static final String CREATE_TABLE = 
					"CREATE TABLE "+CMSDatabaseContract.tables.Teacher.TABLE_NAME+" ("+
					CMSDatabaseContract.tables.Teacher._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
					CMSDatabaseContract.tables.Teacher.NAME+" TEXT,"+
					CMSDatabaseContract.tables.Teacher.QUALIFICATION+" TEXT"+
					" )";
		}
	}	
}
