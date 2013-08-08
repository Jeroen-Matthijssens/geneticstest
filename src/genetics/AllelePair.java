package genetics;

public interface AllelePair<T extends Property, E extends Allele<T>> {

	public E getFirstAllele ();
	public E getSecondAllele ();
	public E getRandomAllele ();

	public T getProperty ();
	public AllelePair<T, E> cross (AllelePair<T, E> other);

	public boolean isMutated ();

}
