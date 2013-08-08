package genetics;

public interface Genome {

	public AllelePair getAllelePair (String type);
	public Genome breed (Genome other);
	public Property getProperty (String type);

}
