package horses;

import genetics.Property;
import java.util.HashMap;
import java.util.Map;

public enum JumpProp implements Property {

	FourHalves (2), FiveHalves (2.5), SixHalves (3), SevenHalves (3.5), EightHalves (4),
	NineHalves (4.5), TenHalves (5), ElevenHalves (5.5);
	
	private static final Map<Double, JumpProp> lookup = new HashMap ();
	private double value;
	
	static {
		for (JumpProp prop : JumpProp.values ()) {
			lookup.put ( (double) prop.getValue (), prop);
		}
	}

	JumpProp (double value) { this.value = value; }

	static JumpProp getByValue (double value) {
		return lookup.get (value);
	}

	@Override
	public Object getValue () { return value; }

}
