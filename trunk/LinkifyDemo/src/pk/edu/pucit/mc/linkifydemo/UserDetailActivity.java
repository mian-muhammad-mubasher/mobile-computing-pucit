package pk.edu.pucit.mc.linkifydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class UserDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_detail);
		String userName = getIntent().getDataString().substring(9);
		User user = DataAccessObject.getUser(userName);
		TextView userNameTextView = (TextView)findViewById(R.id.userName);
		TextView realNameTextView = (TextView)findViewById(R.id.realName);
		TextView designationTextView = (TextView)findViewById(R.id.designation);
		TextView educationTextView = (TextView)findViewById(R.id.education);
		userNameTextView.setText(user.getUserName());
		realNameTextView.setText(user.getRealName());
		designationTextView.setText(user.getDesignation());
		educationTextView.setText(user.getEducation());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_detail, menu);
		return true;
	}

}
