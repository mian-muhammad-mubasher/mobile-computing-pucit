package pk.edu.pucit.mc.andenginedemo1;

import java.util.Calendar;

public class Angle {
        
	public float hourAngle;
	public float minuteAngle;
	public float secondAngle;
    
	private Angle(){}
	
	public static Angle calculateAngles(){
    	Angle angles = new Angle(); 
    	Calendar c = Calendar.getInstance();
    	angles.secondAngle = c.get(Calendar.SECOND) * 6;
    	angles.minuteAngle = ((c.get(Calendar.MINUTE)* 60) + c.get(Calendar.SECOND)) * (float).1;
    	angles.hourAngle = ((c.get(Calendar.HOUR) * 60 * 60) + (c.get(Calendar.MINUTE)* 60) + c.get(Calendar.SECOND)) *  (float)0.0083333333333333;
    	return angles;
    }
	
	public static float getSecondAngle(){
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.SECOND) * 6;
	}

	public static float getMinuteAngle(){
		Calendar c = Calendar.getInstance();
		return ((c.get(Calendar.MINUTE)* 60) + c.get(Calendar.SECOND)) * (float).1;
	}
	
	public static float getHourAngle(){
		Calendar c = Calendar.getInstance();
		return ((c.get(Calendar.HOUR) * 60 * 60) + (c.get(Calendar.MINUTE)* 60) + c.get(Calendar.SECOND)) *  (float)0.0083333333333333;
	}
}
