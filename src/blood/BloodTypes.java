package blood;

import genetics.Allele;
import genetics.Property;

public enum BloodTypes implements Allele {

	A (BloodProperties.A), B (BloodProperties.B), O (BloodProperties.O);

	private Property property;

	BloodTypes (BloodProperties type) { property = type; }

	@Override
	public Property getProperty () { return property; }

	@Override
	public Property resolveProperty (Allele other) {
		if ( this == O ) { return other.getProperty (); }
		if ( other == O || this.equals (other) ) { return this.getProperty (); }
		return BloodProperties.AB;
	}

	@Override
	public double getProbability () { return 1.0 / BloodTypes.values ().length; }

}
