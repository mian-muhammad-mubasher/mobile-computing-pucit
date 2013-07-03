package pk.edu.pucit.mc.finaltermquestion8;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class EngineServiceConnection implements ServiceConnection {

	private MainActivity activity;
	
	public EngineServiceConnection(MainActivity activity) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
	}
	
	@Override
	public void onServiceConnected(ComponentName arg0, IBinder binder) {
		// TODO Auto-generated method stub
		EngineBinder eBinder = (EngineBinder)binder;
		activity.engine = eBinder.getStatisticsEngine();
	}

	@Override
	public void onServiceDisconnected(ComponentName arg0) {
		// TODO Auto-generated method stub
		activity.engine = null;
	}

}
