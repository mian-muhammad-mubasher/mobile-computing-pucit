package pk.edu.pucit.mc.finaltermquestion6;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	@SuppressLint("UseSparseArrays")
	private static Map<Integer, Class<? extends Activity>> ACTIVITY_MAP = new HashMap<Integer, Class<? extends Activity>>();
	
	static{
		ACTIVITY_MAP.put(R.id.add_teacher_button, AddTeacherActivity.class);
		ACTIVITY_MAP.put(R.id.add_student_button, AddStudentActivity.class);
		ACTIVITY_MAP.put(R.id.show_teachers_button, ShowTeachersActivity.class);
		ACTIVITY_MAP.put(R.id.show_students_button, ShowStudentsActivity.class);	
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void click(View v){
		startActivity(
				new Intent(this, ACTIVITY_MAP.get(v.getId()))
		);
	}

}
