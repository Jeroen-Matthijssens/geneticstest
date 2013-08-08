package blood;

import genetics.AllelePair;
import genetics.Genome;
import genetics.BasicGenome;
import java.util.Map;
import java.util.HashMap;

public class BloodGenome extends BasicGenome implements Genome {

	public BloodGenome (BloodTypePair type) {
		super ();
		setAllelePair ("blood type", type);
	}
	
	public BloodGenome (BloodTypePair type, BloodTypePair other) {
		this (type);
		setAllelePair ("other", other);
	}

	public BloodGenome (Map<String, AllelePair> pairs) {
		super (pairs);
	}
	
	private static Map<String, AllelePair> aidNew (BloodTypePair type, BloodTypePair other) {
		Map<String, AllelePair> pairs = new HashMap ();
		pairs.put ("blood type", type);
		pairs.put ("other", other);
		return pairs;
	}

	@Override
	protected Genome newInstance (Map<String, AllelePair> pairs) {
		return new BloodGenome (pairs);
	}

	@Override
	protected void randomizeBreeding(Map<String, AllelePair> pairs) {
	}

}
