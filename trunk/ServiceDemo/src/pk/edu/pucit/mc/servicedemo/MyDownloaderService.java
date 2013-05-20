package pk.edu.pucit.mc.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class MyDownloaderService extends IntentService {

	public MyDownloaderService() {
		super("MyDownloaderService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		String urlString = arg0.getStringExtra(Constants.IntentBundleKeys.URL);
		Messenger messenger = (Messenger)arg0.getExtras().get(Constants.IntentBundleKeys.MESSENGER);
		String introduction = Utils.getAsStringFromURL(urlString);
		Message message = Message.obtain();
		message.obj = introduction;
		try {
			messenger.send(message);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
