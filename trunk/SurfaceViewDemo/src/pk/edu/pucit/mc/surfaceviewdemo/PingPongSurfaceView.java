package pk.edu.pucit.mc.surfaceviewdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PingPongSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
	
	private Bitmap mVolleyBall = null;
    private int mHeight;
    private int mWidth;
    private int cx;
    private int cy;
	
	public PingPongSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		getHolder().addCallback(this);
		setBackgroundResource(R.drawable.volleyball_court);
		mVolleyBall = BitmapFactory.decodeResource(getResources(), R.drawable.volleyball);
	}
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        mVolleyBall = Bitmap.createScaledBitmap(mVolleyBall, mWidth/5, mHeight/10, true);
        cx = (mWidth - mVolleyBall.getWidth()) / 2;
        cy = (mHeight - mVolleyBall.getHeight()) / 2;
        setMeasuredDimension(mWidth, mHeight);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		 canvas.drawBitmap(mVolleyBall, cx, cy, null);
	}
	
	Thread t = new Thread(new Runnable() {
		
		private boolean moveRight = true;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (true) {
					if (cx >= mWidth){
						moveRight = false;
					}else if(cx<=0){
						moveRight = true;
					}
					if(moveRight)
						cx++;
					else
						cx--;
					Thread.sleep(5);
					postInvalidate();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
	});

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		t.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		t.interrupt();
	}

}
