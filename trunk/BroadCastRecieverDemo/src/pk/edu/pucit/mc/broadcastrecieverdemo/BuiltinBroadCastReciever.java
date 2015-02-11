package pk.edu.pucit.mc.broadcastrecieverdemo;

import java.util.Calendar;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BuiltinBroadCastReciever extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		// TODO Auto-generated method stub
		Notification n  = new Notification.Builder(context)
		.setContentTitle("Notification")
		.setSmallIcon(R.drawable.ic_launcher)
		.setContentText("An android builtin broadcast has been recived")
		.build();
		;
		NotificationManager notificationManager = 
				  (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(Calendar.getInstance().get(Calendar.MILLISECOND), n);
	}

}
