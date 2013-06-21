package pk.edu.pucit.mc.andenginephysicsdemo;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.hardware.SensorManager;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class MainActivity extends SimpleBaseGameActivity {

	 private static final int CAMERA_WIDTH = 480;
	 private static final int CAMERA_HEIGHT = 800;
	 private static final int BACK_GROUND_TEXTURE_WIDTH = 300;
	 private static final int BACK_GROUND_TEXTURE_HEIGHT = 440;
	 private static final int VOLLEY_BALL_TEXTURE_WIDTH = 550;
	 private static final int VOLLEY_BALL_TEXTURE_HEIGHT= 376;
	 private static final int WOOD_TEXTURE_WIDTH = 780;
	 private static final int WOOD_TEXTURE_HEIGHT= 282;
	 
	 SpriteBackground spriteBackground;
	 Sprite volleyBallSprite;
	 Sprite woodSprite;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
	    EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, 
	    new FillResolutionPolicy(), camera);
	    return engineOptions;
	}

	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub
	    BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	    
	    BitmapTextureAtlas bitmapTextureAtlas = new BitmapTextureAtlas(getTextureManager(), BACK_GROUND_TEXTURE_WIDTH, BACK_GROUND_TEXTURE_HEIGHT, TextureOptions.DEFAULT);
	    ITextureRegion textureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bitmapTextureAtlas, this, "volleyball_court.png", 0, 0);
	    bitmapTextureAtlas.load();
	    spriteBackground = new SpriteBackground(new Sprite(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT,textureRegion, getEngine().getVertexBufferObjectManager()));
	    
	    bitmapTextureAtlas = new BitmapTextureAtlas(getTextureManager(), VOLLEY_BALL_TEXTURE_WIDTH, VOLLEY_BALL_TEXTURE_HEIGHT, TextureOptions.DEFAULT);
	    textureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bitmapTextureAtlas, this, "volleyball.png", 0, 0);
	    bitmapTextureAtlas.load();
	    volleyBallSprite = new Sprite(CAMERA_WIDTH/2, 0, CAMERA_WIDTH/5, CAMERA_HEIGHT/10, textureRegion, getEngine().getVertexBufferObjectManager());
	    
	    bitmapTextureAtlas = new BitmapTextureAtlas(getTextureManager(), WOOD_TEXTURE_WIDTH, WOOD_TEXTURE_HEIGHT, TextureOptions.DEFAULT);
	    textureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bitmapTextureAtlas, this, "wood.png", 0, 0);
	    bitmapTextureAtlas.load();
	    woodSprite = new Sprite(0, CAMERA_HEIGHT-300, CAMERA_WIDTH/10, CAMERA_HEIGHT/50, textureRegion, getEngine().getVertexBufferObjectManager());
	}

	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub
		Scene scene = new Scene();
	    scene.setBackground(spriteBackground);
	    scene.attachChild(volleyBallSprite);
	    scene.attachChild(woodSprite);
	    
	    PhysicsWorld physicsWorld = new PhysicsWorld(new Vector2(1, SensorManager.GRAVITY_EARTH), true);
	    
	    final FixtureDef objectFixtureDef = PhysicsFactory.createFixtureDef(1, 0.5f, 0.5f);

	    Body body = PhysicsFactory.createBoxBody(physicsWorld, volleyBallSprite, BodyType.DynamicBody, objectFixtureDef);
	    physicsWorld.registerPhysicsConnector(new PhysicsConnector(volleyBallSprite, body, true, true));

	    Body body1 = PhysicsFactory.createBoxBody(physicsWorld, woodSprite, BodyType.StaticBody, objectFixtureDef);
	    physicsWorld.registerPhysicsConnector(new PhysicsConnector(woodSprite, body1, true, true));
	    
	    scene.registerUpdateHandler(physicsWorld);
	    return scene;
	}

}
