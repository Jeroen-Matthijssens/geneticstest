package horses;

import genetics.BasicPair;

public class HealthPair extends BasicPair<HealthProp, HealthAllele> {

	public HealthPair (HealthAllele first, HealthAllele second) { super (first, second); }

	public static HealthPair newRandom () {
		HealthAllele first = HealthAllele.getRandom ();
		HealthAllele second = HealthAllele.getRandom ();
		return new HealthPair (first, second);
	}

}
