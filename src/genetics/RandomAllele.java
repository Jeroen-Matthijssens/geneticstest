package genetics;

public class RandomAllele {

	public static <E extends Allele> E getRandom (E[] alleles) {
		double r = Math.random ();
		double current = 0;
		for ( E allele : alleles ) {
			current = current + allele.getProbability ();
			if ( r < current ) { return allele; }
		}
		throw new RuntimeException ("The probabilities do not sum to 1.");
	}

}
