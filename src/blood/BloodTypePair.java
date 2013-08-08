package blood;

import genetics.Allele;
import genetics.AllelePair;
import genetics.BasicPair;

public class BloodTypePair extends BasicPair implements AllelePair {

	public BloodTypePair (Allele first, Allele second) {
		super (first, second);
	}

	@Override
	protected AllelePair newInstance(Allele first, Allele second) {
		return new BloodTypePair (first, second);
	}

	@Override
	public String toString () {
		return String.format ("(p: %s, %s)"
				, getFirstAllele ().getProperty ()
				, getSecondAllele ().getProperty ()
				);
	}

}
