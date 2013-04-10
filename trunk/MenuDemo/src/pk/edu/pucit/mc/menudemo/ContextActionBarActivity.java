package pk.edu.pucit.mc.menudemo;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

@SuppressLint("NewApi")
public class ContextActionBarActivity extends MySharedCodeActivity {

	ActionMode mActionMode = null;
	
	private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

	    // Called when the action mode is created; startActionMode() was called
	    @Override
	    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
	        // Inflate a menu resource providing context menu items
	        MenuInflater inflater = mode.getMenuInflater();
	        inflater.inflate(R.menu.basic_menu, menu);
	        return true;
	    }

	    // Called each time the action mode is shown. Always called after onCreateActionMode, but
	    // may be called multiple times if the mode is invalidated.
	    @Override
	    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
	        return false; // Return false if nothing is done
	    }

	    // Called when the user selects a contextual menu item
	    @Override
	    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
	    	return ContextActionBarActivity.this.onOptionsItemSelected(item);
	    }

	    // Called when the user exits the action mode
	    @Override
	    public void onDestroyActionMode(ActionMode mode) {
	        mActionMode = null;
	    }
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic_menu);
		TextView tv = (TextView) findViewById(R.id.my_text_view);
		tv.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				if (mActionMode != null){
					return false;
				}else{					
					mActionMode = ContextActionBarActivity.this.startActionMode(mActionModeCallback);
					v.setSelected(true);
					return true;
				}
			}
		});
	}

	public void showPopUp(View v){}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.context_action_bar, menu);
		return true;
	}

}
