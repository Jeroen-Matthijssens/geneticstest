package horses;

import genetics.Property;
import java.util.HashMap;
import java.util.Map;

public enum HealthProp implements Property {

	Ten (10), Eleven (11), Twelve (12), Thirteen (13), Forteen (14), Fifteen (15),
	Sixteen (16), Seventeen (17), Eighteen (18), Nineteen (19), Twenty (20);

	private static final Map<Integer, HealthProp> lookup = new HashMap ();
	private int value;

	static {
		for (HealthProp prop : HealthProp.values ()) {
			lookup.put ( (int) prop.getValue (), prop);
		}
	}

	HealthProp (int value) { this.value = value; }

	static HealthProp getByValue (int value) {
		return lookup.get (value);
	}

	@Override
	public Object getValue () { return value; }

}
