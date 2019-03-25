import edu.princeton.cs.algs4.In;

public class Outcast {

    private WordNet wordNet = null;
    
    public Outcast(WordNet wordnet) {
        wordNet = wordnet;
    }
    
    public String outcast(String[] nouns) {
        int[] distances = new int[nouns.length];
        for (int i = 0; i < nouns.length; i++) {
            for (int j = i + 1; j < nouns.length; j++) {
                int dist = wordNet.distance(nouns[i], nouns[j]);
                distances[i] += dist;
                distances[j] += dist;
            }
        }
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] > max) {
                max = distances[i];
                maxIdx = i;
            }
        }
        return nouns[maxIdx];
    }
    
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
//        args = new String[]{"synsets.txt", "hypernyms.txt", "outcast5.txt", "outcast8.txt", "outcast11.txt"};
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            System.out.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }

}
