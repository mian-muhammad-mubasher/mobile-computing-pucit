package pk.edu.pucit.mc.finaltermquestion8;

import android.os.Binder;

public class EngineBinder extends Binder {
	
	public DegreeStatisticsEngine getStatisticsEngine(){
		return new BSStatisticsEngine();
	}
	
}
