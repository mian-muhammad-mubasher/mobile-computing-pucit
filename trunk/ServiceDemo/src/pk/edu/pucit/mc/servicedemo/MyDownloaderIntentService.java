package pk.edu.pucit.mc.servicedemo;

import android.app.IntentService;
import android.content.Intent;

public class MyDownloaderIntentService extends IntentService {

	public MyDownloaderIntentService() {
		super("MyDownloaderIntentService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		Utils.download(this, arg0);
	}

}
