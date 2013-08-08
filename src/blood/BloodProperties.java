package blood;

import genetics.Property;

public enum BloodProperties implements Property {
	O ("O"), A ("A"), B("B"), AB ("AB");

	private Object value;

	BloodProperties (String type) { this.value = type; }

	public Object getValue () { return this.value; }
}
