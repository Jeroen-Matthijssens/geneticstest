package horses;

import genetics.Property;

import java.util.Map;
import java.util.HashMap;

public enum SpeedProp implements Property {

	One (7), Two(8), Three (9), Four (10), Five (11), Six (12);

	private static final Map<Integer, SpeedProp> byValue = new HashMap ();
	private final int value;

	static {
		for ( SpeedProp speed : SpeedProp.values () ) {
			byValue.put ( (int) speed.getValue (), speed);
		}
	}

	SpeedProp (int value) { this.value = value; }

	@Override
	public Object getValue() { return value; }

	public SpeedProp down () {
		int v = Math.max (7, (int) getValue () - 1);
		return byValue.get (v);
	}

	public SpeedProp up () {
		int v = Math.min (12, (int) getValue () + 1);
		return byValue.get (v);
	}

}