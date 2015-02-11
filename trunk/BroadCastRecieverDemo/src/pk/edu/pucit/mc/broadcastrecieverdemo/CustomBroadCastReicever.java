package pk.edu.pucit.mc.broadcastrecieverdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CustomBroadCastReicever extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.i("custom.broadcast", "custom.broadcast");
//		Notification n  = new Notification.Builder(context)
//		.setContentTitle("Notification")
//		.setContentText("A ccustom broadcast has been recived")
//		.build();
//		;
//		NotificationManager notificationManager = 
//				  (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//		notificationManager.notify(0, n);
	}

}
