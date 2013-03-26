package pk.edu.pucit.mc.listviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startListViewActivity(View v){
    	Intent i = new Intent(this, MyListActivity.class);
    	startActivity(i);
    }
    
    public void startGridViewActivity(View v){
    	Intent i = new Intent(this, MyGridActivity.class);
    	startActivity(i);    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
