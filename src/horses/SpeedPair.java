package horses;

import genetics.BasicPair;

public class SpeedPair extends BasicPair<SpeedProp, SpeedAllele> {

	public SpeedPair (SpeedAllele first, SpeedAllele second) { super (first, second); }

	public static SpeedPair newRandom () {
		SpeedAllele first = SpeedAllele.getRandom ();
		SpeedAllele second = SpeedAllele.getRandom ();
		return new SpeedPair (first, second);
	}

}
