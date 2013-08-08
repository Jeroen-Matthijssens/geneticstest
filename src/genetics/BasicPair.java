package genetics;

import java.lang.reflect.Constructor;

public abstract class BasicPair<P extends Property, A extends Allele<P>>
		implements AllelePair<P, A> {

	private A first;
	private A second;
	private boolean mutated = false;

	public BasicPair (A first, A second) {
		setFirstAllele (first);
		setSecondAllele (second);
	}

	protected void setFirstAllele (A first) { this.first = first; }
	protected void setSecondAllele (A second) { this.second = second; }

	@Override
	public A getFirstAllele () { return first; }

	@Override
	public A getSecondAllele () {return second; }

	@Override
	public P getProperty () { return first.resolveProperty (second); }

	@Override
	public A getRandomAllele () {
		double chanceFirst = getFirstAllele ().getProbability ();
		double chanceSecond = getSecondAllele ().getProbability ();
		double total = chanceFirst + chanceSecond;
		if ( Math.random () < chanceFirst / total ) { return getFirstAllele (); }
		else { return getSecondAllele (); }
	}

	@Override
	public AllelePair<P, A> cross (AllelePair<P, A> other) {
		A newfirst = getRandomAllele ();
		A newsecond = other.getRandomAllele ();
		try { return newInstance (newfirst, newsecond); }
		catch (Exception ex) { throw new RuntimeException (ex); }
	}

	protected AllelePair<P, A> newInstance (A first, A second) throws Exception {
		Class cl = first.getClass ();
		Constructor c = this.getClass ().getConstructor (cl, cl);
		return (AllelePair<P, A>) c.newInstance (new Object [] {first, second});
	}

	@Override
	public boolean isMutated () { return mutated; }
	public void setMutated (boolean mutated) { this.mutated = mutated; }

	@Override
	public String toString () {
		String s;
		if ( isMutated () ) { s = "(#M: %s, %s)"; }
		else { s = "(p: %s, %s)"; }
		return String.format (s, first, second);
	}

}
