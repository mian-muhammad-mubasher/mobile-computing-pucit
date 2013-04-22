package pk.edu.pucit.mc.canvasdemo;

import java.util.Calendar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class MyAnalogClock extends View {

	private Bitmap mHourNeedle = null;
	private Bitmap mMinuteNeedle = null;
	private Bitmap mSecondNeedle = null;
	private int mHeight;
	private int mWidth;
	
	public MyAnalogClock(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		setBackgroundResource(R.drawable.clock_dial);
		mHourNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.clock_hour);
		mMinuteNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.clock_minute);
		mSecondNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.clock_second);
	}
	

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
	    mWidth = View.MeasureSpec.getSize(widthMeasureSpec);
	    mHeight = View.MeasureSpec.getSize(heightMeasureSpec);

	    setMeasuredDimension(mWidth, mHeight);
	}
	
	private class Angles{
		private float hourAngle;
		private float minuteAngle;
		private float secondAngle;
	}
	
	private Angles calculateAngles(){
		Angles angles = new Angles(); 
		Calendar c = Calendar.getInstance();
		angles.secondAngle = c.get(Calendar.SECOND) * 6;
		angles.minuteAngle = ((c.get(Calendar.MINUTE)* 60) + c.get(Calendar.SECOND)) * (float).1;
		angles.hourAngle = ((c.get(Calendar.HOUR) * 60 * 60) + (c.get(Calendar.MINUTE)* 60) + c.get(Calendar.SECOND)) *  (float)0.0083333333333333;
		return angles;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		int cx = 0; 
		int cy = 0; 
		cx = (mWidth - mHourNeedle.getWidth()) / 2;
	    cy = (mHeight - mHourNeedle.getHeight()) / 2;
	    Angles angles = calculateAngles();
	    
	    canvas.save();
	    canvas.rotate(angles.secondAngle, mWidth/2, mHeight/2);
	    canvas.drawBitmap(mSecondNeedle, cx, cy, null);
	    canvas.restore();
	    
	    canvas.save();
	    canvas.rotate(angles.minuteAngle, mWidth/2, mHeight/2);
	    canvas.drawBitmap(mMinuteNeedle, cx, cy, null);
	    canvas.restore();
	    
	    canvas.rotate(angles.hourAngle, mWidth/2, mHeight/2);
	    canvas.drawBitmap(mHourNeedle, cx, cy, null);
	    
	}
	
}
