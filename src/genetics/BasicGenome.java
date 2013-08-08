package genetics;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class BasicGenome implements Genome {

	private Map<String, AllelePair> allelePairs;

	public BasicGenome () { this.allelePairs = new HashMap (); }
	public BasicGenome (Map<String, AllelePair> pairs) { this.allelePairs = pairs; }

	protected abstract void randomizeBreeding (Map<String, AllelePair> pairs);

	protected void setAllelePair (String type, AllelePair pair) {
		allelePairs.put (type, pair);
	}

	@Override
	public AllelePair getAllelePair (String type) {
		return allelePairs.get (type);
	}

	@Override
	public Property getProperty (String type) {
		assert (getAllelePair (type) != null);
		return getAllelePair (type).getProperty ();
	}

	@Override
	public Genome breed (Genome other) {
		Map<String, AllelePair> newpairs = new HashMap ();

		for ( String type : allelePairs.keySet () ) {
			AllelePair first = getAllelePair (type);
			AllelePair second = other.getAllelePair (type);
			newpairs.put (type, first.cross (second));
		}

		randomizeBreeding (newpairs);

		try { return newInstance (newpairs); }
		catch (Exception ex) { throw new RuntimeException (ex); }
	}

	protected Genome newInstance (Map<String, AllelePair> pairs) throws Exception {
		Constructor c = this.getClass ().getConstructor (Map.class);
		return (Genome) c.newInstance (new Object [] {pairs});
	}

	protected void mutate (String s, Map<String, AllelePair> pairs) {
		AllelePair pair = pairs.get (s);
		try {
			Class cl = pair.getClass ();
			Method m = cl.getMethod ("newRandom");
			
			AllelePair newPair = pair.cross ((AllelePair) m.invoke (new Object [0]));
			((BasicPair) newPair).setMutated (true);
			
			pairs.put (s, newPair);
		} catch (Exception ex) {
			throw new RuntimeException (ex);
		}
	}

	@Override
	public String toString () {
		StringBuilder s = new StringBuilder ();
		s.append ("<Genome:");
		for (String key : allelePairs.keySet ()) {
			s.append (" -").append (key).append (": ");
			s.append (getAllelePair (key).getProperty ().getValue ());
			if ( getAllelePair (key).isMutated () ) { s.append ("M"); }
		}
		s.append (">");
		// s.append ("> -- ").append (allelePairs.toString ());
		return s.toString ();
	}
	
	public String extraInfo () { return allelePairs.toString (); }

}