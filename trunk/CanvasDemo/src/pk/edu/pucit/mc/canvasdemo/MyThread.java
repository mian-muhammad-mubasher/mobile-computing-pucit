package pk.edu.pucit.mc.canvasdemo;

import android.view.View;

public class MyThread extends Thread {
	
	private View v;
	
	public MyThread(View v) {
		// TODO Auto-generated constructor stub
		this.v = v;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				sleep(1000);
				v.postInvalidate();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
