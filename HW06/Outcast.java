import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


// An immutable data type for outcast detection.
public class Outcast {
    private final WordNet wdn;
    private ShortestCommonAncestor scancestor;

    // Construct an Outcast object given a WordNet object.
    public Outcast(WordNet wdn) {
        this.wdn = wdn;
    }

    // The outcast noun from nouns.
    public String outcast(String[] nounss) {
        int mDistance = 0;
		String ocast = "" ;
		for (int i = 0; i < nounss.length; i++ ) {
			int d = 0;
			for (int j = 0; j < nounss.length; j++ ) {
			d += wdn.distance(nounss[i], nounss[j]);
		}
			if (d > mDistance) {
			mDistance = d;
			ocast = nounss[i];
			}
}
		return ocast;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args)  {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println("outcast(" + args[t] + ") = "
                           + outcast.outcast(nouns));
        }
    }
}