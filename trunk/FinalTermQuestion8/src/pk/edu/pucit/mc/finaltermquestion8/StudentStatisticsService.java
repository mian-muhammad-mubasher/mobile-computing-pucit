package pk.edu.pucit.mc.finaltermquestion8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class StudentStatisticsService extends Service {
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return new EngineBinder();
	}

}
