package horses;

import genetics.Allele;
import genetics.RandomAllele;

public enum SpeedAllele implements Allele<SpeedProp> {

	Slow (SpeedProp.Two, 0.40),
	Up (SpeedProp.Two, 0.10),
	Down (SpeedProp.Five, 0.10),
	Fast (SpeedProp.Five, 0.40),
	Dud (SpeedProp.Three, 0.30);

	private SpeedProp property;
	private double probability;

	SpeedAllele (SpeedProp property, double probability) {
		this.property = property;
		this.probability = probability;
	}

	public static SpeedAllele getRandom () {
		return RandomAllele.getRandom (SpeedAllele.values ());
	}

	@Override
	public SpeedProp getProperty() { return property; }

	@Override
	public double getProbability () { return probability; }

	@Override
	public SpeedProp resolveProperty(Allele<SpeedProp> other) {
		if ( this == other ) { return getProperty (); }

		if ( this == Dud ) { return other.getProperty (); }
		if ( other == Dud ) { return getProperty (); }
		if ( this == Up ) { return other.getProperty ().up (); }
		if ( other == Up ) { return getProperty ().up (); }
		if ( this == Down ) { return other.getProperty ().down (); }
		if ( other == Down ) { return getProperty ().down (); }

		else { return SpeedProp.Three; }
	}

}
