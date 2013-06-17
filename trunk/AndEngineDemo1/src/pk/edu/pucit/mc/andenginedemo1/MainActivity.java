package pk.edu.pucit.mc.andenginedemo1;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public class MainActivity extends SimpleBaseGameActivity {

	private Camera camera;
	private static final int CAMERA_WIDTH = 400;
	private static final int CAMERA_HEIGHT = 800;
	private static final int TEXTURE_WIDTH = 288 + (48 * 3) ;
	private static final int TEXTURE_HEIGHT = 288;
	private BitmapTextureAtlas clockBitmapTextureAtlas = null;
	private SpriteBackground dialSprite = null;
	private Sprite hourNeedleSprite = null;
	private Sprite minuteNeedleSprite = null;
	private Sprite secondNeedleSprite = null;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
	    camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
	    EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, 
	    new FillResolutionPolicy(), camera);
	    return engineOptions;
	}

	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub
	    BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	    clockBitmapTextureAtlas = new BitmapTextureAtlas(getTextureManager(), TEXTURE_WIDTH, TEXTURE_HEIGHT, TextureOptions.DEFAULT);
	    ITextureRegion dialTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clockBitmapTextureAtlas, this, "clock_dial.png", 0, 0);
	    ITextureRegion hourNeedleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clockBitmapTextureAtlas, this, "clock_hour.png", 288+(48*0), 0);
	    ITextureRegion minuteNeedleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clockBitmapTextureAtlas, this, "clock_minute.png", 288+(48*1), 0);
	    ITextureRegion secondNeedleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clockBitmapTextureAtlas, this, "clock_second.png", 288+(48*2), 0);
	    clockBitmapTextureAtlas.load();
	    dialSprite = new SpriteBackground(new Sprite(0, 0, dialTextureRegion.getWidth(), dialTextureRegion.getHeight(), dialTextureRegion, getEngine().getVertexBufferObjectManager()));
	    float x = (dialTextureRegion.getWidth() - hourNeedleTextureRegion.getWidth()) / 2;
	    float y = (dialTextureRegion.getHeight() - hourNeedleTextureRegion.getHeight()) / 2;
	    hourNeedleSprite = new Sprite(x, y, hourNeedleTextureRegion.getWidth(), hourNeedleTextureRegion.getHeight(), hourNeedleTextureRegion, getEngine().getVertexBufferObjectManager()){
	    	@Override
	    	protected void onManagedUpdate(float pSecondsElapsed) {
	    		// TODO Auto-generated method stub
	    		
	    		setRotation(Angle.getHourAngle());
	    		super.onManagedUpdate(pSecondsElapsed);
	    	}
	    };
	    hourNeedleSprite.setRotationCenter(hourNeedleSprite.getWidth()/2, hourNeedleSprite.getHeight()/2);
	    minuteNeedleSprite = new Sprite(x, y, minuteNeedleTextureRegion.getWidth(), minuteNeedleTextureRegion.getHeight(), minuteNeedleTextureRegion, getEngine().getVertexBufferObjectManager()){
	    	@Override
	    	protected void onManagedUpdate(float pSecondsElapsed) {
	    		// TODO Auto-generated method stub
	    		setRotation(Angle.getMinuteAngle());
	    		super.onManagedUpdate(pSecondsElapsed);
	    	}	    	
	    };
	    minuteNeedleSprite.setRotationCenter(minuteNeedleSprite.getWidth()/2, minuteNeedleSprite.getHeight()/2);
	    secondNeedleSprite = new Sprite(x, y, secondNeedleTextureRegion.getWidth(), secondNeedleTextureRegion.getHeight(), secondNeedleTextureRegion, getEngine().getVertexBufferObjectManager()){
	    	@Override
	    	protected void onManagedUpdate(float pSecondsElapsed) {
	    		// TODO Auto-generated method stub
	    		setRotation(Angle.getSecondAngle());
	    		super.onManagedUpdate(pSecondsElapsed);
	    	}	    	
	    };
	    secondNeedleSprite.setRotationCenter(secondNeedleSprite.getWidth()/2, secondNeedleSprite.getHeight()/2);
	}

	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub
		Scene scene = new Scene();
	    scene.setBackground(dialSprite);
	    scene.attachChild(hourNeedleSprite);
	    scene.attachChild(minuteNeedleSprite);
	    scene.attachChild(secondNeedleSprite);
	    return scene;
	}

}
