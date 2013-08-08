package genetics;

public interface Allele<E extends Property> {

	public E getProperty ();
	public E resolveProperty (Allele<E> other);
	public double getProbability ();

}
