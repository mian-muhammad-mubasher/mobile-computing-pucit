package pk.edu.pucit.mc.fragmentdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	public static Movie[] movies = new Movie[]{
		new Movie("G.I. Joe: Retaliation","The G.I. Joes are not only fighting their mortal enemy Cobra; they are forced to contend with threats from within the government that jeopardize their very existence."),
		new Movie("Evil Dead","Five friends head to a remote cabin, where the discovery of a Book of the Dead leads them to unwittingly summon up demons living in the nearby woods. The evil presence possesses them until only one is left to fight for survival."),
		new Movie("The Host","When an unseen enemy threatens mankind by taking over their bodies and erasing their memories, Melanie will risk everything to protect the people she cares most about, proving that love can conquer all in a dangerous new world."),
		new Movie("Olympus Has Fallen","The G.I. Joes are not only fighting their mortal enemy Cobra; they are forced to contend with threats from within the government that jeopardize their very existence."),
		new Movie("The Croods","After their cave is destroyed, a caveman family must trek through an unfamiliar fantastical world with the help of an inventive boy."),
		new Movie("Gangster Squad","Los Angeles, 1949: A secret crew of police officers led by two determined sergeants work together in an effort to take down the ruthless mob king Mickey Cohen who runs the city."),
		new Movie("Oz the Great and Powerful","A small-time magician is swept away to an enchanted land and is forced into a power struggle between three witches."),
		new Movie("Temptation: Confessions of a Marriage Counselor","An ambitious married woman's temptation by a handsome billionaire leads to betrayal, recklessness, and forever alters the course of her life."),
		new Movie("Welcome to the Punch","Ex-criminal Jacob Sternwood is forced to return to London when his son is involved in a heist gone wrong. This gives his nemesis, detective Max Lewinsky, one last chance to catch the man he's always been after."),
		new Movie("Oblivion","A veteran assigned to extract Earth's remaining resources begins to question what he knows about his mission and himself."),
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onMovieSelect(int position){
		DetailFragment df = (DetailFragment)getFragmentManager().findFragmentById(R.id.detail_fragment);
		df.onMovieSelect(position);
	}

}
