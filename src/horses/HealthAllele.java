package horses;

import genetics.Allele;
import genetics.RandomAllele;

public enum HealthAllele implements Allele<HealthProp> {

	Ten (HealthProp.Ten),
	Eleven (HealthProp.Eleven),
	Twelve (HealthProp.Twelve),
	Thirtheen (HealthProp.Thirteen),
	Forteen (HealthProp.Forteen),
	Fifteen (HealthProp.Fifteen),
	Sixteen (HealthProp.Sixteen),
	Seventeen (HealthProp.Seventeen),
	Eighteen (HealthProp.Eighteen),
	Nineteen (HealthProp.Nineteen),
	Twenty (HealthProp.Twenty);

	private HealthProp property;
	private final static double probability = 1.0 / HealthAllele.values ().length;
	

	HealthAllele (HealthProp p) {this.property = p; }

	public static HealthAllele getRandom () {
		return RandomAllele.getRandom (HealthAllele.values ());
	}

	@Override
	public HealthProp getProperty () { return property; }

	@Override
	public double getProbability () { return probability; }
	
	@Override
	public HealthProp resolveProperty (Allele<HealthProp> other) {
		int first = (int) other.getProperty ().getValue ();
		int second = (int) getProperty ().getValue ();

		if ( first < second ) { return other.getProperty (); }
		else { return getProperty (); }
	}

}
