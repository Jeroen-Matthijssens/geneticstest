package horses;

import genetics.Allele;
import genetics.RandomAllele;

public enum JumpAllele implements Allele<JumpProp> {

	Poor (JumpProp.FiveHalves, 0.25),
	Average (JumpProp.SixHalves, 0.45),
	Good (JumpProp.EightHalves, 0.22),
	Exelent (JumpProp.NineHalves, 0.08);

	private JumpProp property;
	private double probability;

	JumpAllele (JumpProp property, double probability) {
		this.property = property;
		this.probability = probability;
	}

	public static JumpAllele getRandom () {
		return RandomAllele.getRandom (JumpAllele.values ());
	}

	@Override
	public JumpProp getProperty() { return property; }

	@Override
	public double getProbability () { return probability; }

	@Override
	public JumpProp resolveProperty(Allele<JumpProp> other) {
		double i = (double) this.getProperty ().getValue ();
		double j = (double) other.getProperty ().getValue ();
		double avg = (i + j) / 2;

		if ( this == Poor || other == Poor ) { avg = avg - 0.5; }
		if ( this == Average || other == Average ) { avg = avg - 0.25; }
		if ( this == Good || other == Good ) { avg = avg + 0.25; }
		if ( this == Exelent || other == Exelent ) { avg = avg + 0.25; }
		if ( this == other ) { avg = avg + 0.5; }
		if ( this != other ) { avg = avg - 0.25; }

		avg = Math.round (avg * 2) / 2d;
		avg = Math.max (2, avg);
		avg = Math.min (5.5, avg);
		return JumpProp.getByValue (avg);
	}

}
