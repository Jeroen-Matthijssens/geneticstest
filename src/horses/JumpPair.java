package horses;

import genetics.BasicPair;

public class JumpPair extends BasicPair<JumpProp, JumpAllele> {

	public JumpPair (JumpAllele first, JumpAllele second) { super (first, second); }

	public static JumpPair newRandom () {
		JumpAllele first = JumpAllele.getRandom ();
		JumpAllele second = JumpAllele.getRandom ();
		return new JumpPair (first, second);
	}

}
