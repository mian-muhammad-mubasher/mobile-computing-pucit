package pk.edu.pucit.mc.andenginedemo;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
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
	private static final int TEXTURE_WIDTH = 512;
	private static final int TEXTURE_HEIGHT = 512;
	private BitmapTextureAtlas mapBitmapTextureAtlas = null;
	private ITextureRegion logoTextureRegion = null;
	private Sprite logoSprite = null;
	
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
	    mapBitmapTextureAtlas = new BitmapTextureAtlas(getTextureManager(), TEXTURE_WIDTH, TEXTURE_HEIGHT, TextureOptions.DEFAULT);
	    logoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mapBitmapTextureAtlas, this, "logo.png", 0, 0);
	    mapBitmapTextureAtlas.load();
	    logoSprite = new Sprite(0, 0, logoTextureRegion.getWidth(), logoTextureRegion.getHeight(),logoTextureRegion, getEngine().getVertexBufferObjectManager());
	    logoSprite.setRotation(45);
//	    http://en.wikipedia.org/wiki/Vertex_Buffe
	}

	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub
		Scene scene = new Scene();
	    scene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));
	    scene.attachChild(logoSprite);
	    return scene;
	}

}
