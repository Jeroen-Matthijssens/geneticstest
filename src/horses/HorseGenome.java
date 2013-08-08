package horses;

import genetics.BasicGenome;
import genetics.Genome;
import genetics.AllelePair;

import java.util.Map;

public class HorseGenome extends BasicGenome implements Genome {

	public HorseGenome (HealthPair health, JumpPair jump, SpeedPair speed) {
		super ();
		setAllelePair ("health", health);
		setAllelePair ("jump", jump);
		setAllelePair ("speed", speed);
	}

	public HorseGenome (Map<String, AllelePair> pairs) {
		super (pairs);
		assert (pairs.keySet ().contains ("health"));
		assert (pairs.keySet ().contains ("jump"));
		assert (pairs.keySet ().contains ("speed"));
		assert (pairs.size () == 3);
	}

	@Override
	protected void randomizeBreeding(Map<String, AllelePair> pairs) {
		double r = Math.random ();

		if ( r < 0.4 ) { }
		else if ( r < 0.6 ) { mutate ("health", pairs); }
		else if ( r < 0.8 ) { mutate ("jump", pairs); }
		else { mutate ("speed", pairs); }
	}

	public static HorseGenome newRandom () {
		HealthPair health = HealthPair.newRandom ();
		JumpPair jump = JumpPair.newRandom ();
		SpeedPair speed = SpeedPair.newRandom ();
		return new HorseGenome (health, jump, speed);
	}

}
