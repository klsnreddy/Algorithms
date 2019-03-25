import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class WordNet {

    private HashMap<String, List<Integer>> words = null;
    private HashMap<String, String> ids = null;
    private Digraph graph = null;
    private SAP sap = null;
    
    public WordNet(String synsets, String hypernyms) {
        if (null == synsets || null == hypernyms) {
            throw new NullPointerException("Argument is null");
        }
        In in = new In(hypernyms);
        String line = null;
        List<String> lines = new ArrayList<String>();
        int len = 0;
        while ((line = in.readLine()) != null) {
            if (line.isEmpty())
                continue;
            lines.add(line);
            for (String str : line.split(",")) {
                int i = Integer.parseInt(str.trim());
                if (i > len)
                    len = i;
            }
        }
        
        graph = new Digraph(len + 1);
        String[] hypers = null;
        int id;
        for (String hyper : lines) {
            if (hyper.isEmpty())
                continue;
            hypers = hyper.split(",");
            if (hypers.length < 2)
                continue;
            id = Integer.parseInt(hypers[0].trim());
            for (int i = 1; i < hypers.length; i++)
                graph.addEdge(id, Integer.parseInt(hypers[i].trim()));
        }
        lines = null;
        
        DirectedCycle dag = new DirectedCycle(graph);
        if (dag.hasCycle())
            throw new IllegalArgumentException("Graph in not a DAG");
        
        int rootCount = 0;
        for (int i = 0; i < len + 1; i++) {
            if (!graph.adj(i).iterator().hasNext())
                rootCount++;
            if (rootCount > 1)
                throw new IllegalArgumentException("Graph in not a rooted DAG");
        }
        
        sap = new SAP(graph);
        
        words = new HashMap<String, List<Integer>>();
        ids = new HashMap<String, String>();
        
        in = new In(synsets);
        
        String[] info = null;
        String[] syns = null;
        while ((line = in.readLine()) != null) {
            if (line.isEmpty())
                continue;
            info = line.split(",");
            if (info.length < 2)
                continue;
            ids.put(info[0].trim(), info[1].trim());
            syns = info[1].trim().split(" ");
            List<Integer> idVals = null;
            for (int i = 0; i < syns.length; i++) {
                idVals = words.get(syns[i]);
                if (null == idVals) {
                    idVals = new ArrayList<Integer>();
                    words.put(syns[i], idVals);
                }
                idVals.add(Integer.parseInt(info[0].trim()));
            }
        }
        
    }
    
    public Iterable<String> nouns() {
        return this.words.keySet();
    }
    
    public boolean isNoun(String word) {
        if (null == word) {
            throw new NullPointerException("Argument is null");
        }
        return this.words.containsKey(word);
    }
    
    public int distance(String nounA, String nounB) {
        if (null == nounA || null == nounB) {
            throw new NullPointerException("Argument is null");
        }
        if (!isNoun(nounA))
            throw new IllegalArgumentException(nounA + " is not there in word net");
        if (!isNoun(nounB))
            throw new IllegalArgumentException(nounB + " is not there in word net");
        return sap.length(words.get(nounA), words.get(nounB));
    }
    
    public String sap(String nounA, String nounB) {
        if (null == nounA || null == nounB) {
            throw new NullPointerException("Argument is null");
        }
        if (!isNoun(nounA))
            throw new IllegalArgumentException(nounA + " is not there in word net");
        if (!isNoun(nounB))
            throw new IllegalArgumentException(nounB + " is not there in word net");
        int ancesstor = sap.ancestor(words.get(nounA), words.get(nounB));
        return ids.get(String.valueOf(ancesstor));
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        WordNet wordNet = new WordNet("synsets100-subgraph.txt", "hypernyms100-subgraph.txt");
        System.out.println(wordNet.distance("freshener", "thing"));
    }

}
