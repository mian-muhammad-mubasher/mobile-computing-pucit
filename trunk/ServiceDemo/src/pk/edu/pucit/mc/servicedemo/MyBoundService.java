package pk.edu.pucit.mc.servicedemo;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyBoundService extends Service {
	
	public class LocalBinder extends Binder{
		public MyBoundService getService(){
			return MyBoundService.this;
		}
	}
	
	private IBinder mBinder = new LocalBinder();
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}
	
	public int aVeryComplexAlgorithem(){
		return new Random().nextInt();
	}

}
