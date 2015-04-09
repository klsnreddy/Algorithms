

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author kallam
 * This class will provide the distance between nodes and ancestors.
 *
 */
public class SAP {

    private static int INFINITY = Integer.MAX_VALUE;
    private Digraph graph = null;
    
    public SAP(Digraph G) {
        this.graph = new Digraph(G);
    }
    
    public int length(int v, int w) {
        BreadthFirstDirectedPaths bdpV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bdpW = new BreadthFirstDirectedPaths(graph, w);
        int len = INFINITY;
        int vDist = INFINITY;
        int wDist = INFINITY;
        for (int i = 0; i < graph.V(); i++) {
            vDist = bdpV.distTo(i);
            wDist = bdpW.distTo(i);
            if (vDist != INFINITY && wDist != INFINITY && len > vDist + wDist)
                len = vDist + wDist;
        }
        if (len != INFINITY)
            return len;
        else 
            return -1;
    }
    
    public int ancestor(int v, int w) {
        BreadthFirstDirectedPaths bdpV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bdpW = new BreadthFirstDirectedPaths(graph, w);
        int len = INFINITY;
        int ancestor = -1;
        int vDist = INFINITY;
        int wDist = INFINITY;
        for (int i = 0; i < graph.V(); i++) {
            vDist = bdpV.distTo(i);
            wDist = bdpW.distTo(i);
            if (vDist != INFINITY && wDist != INFINITY && len > vDist + wDist) {
                len = vDist + wDist;
                ancestor = i;
            }
        }
        return ancestor;
    }
    
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths bdpV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bdpW = new BreadthFirstDirectedPaths(graph, w);
        int len = INFINITY;
        int vDist = INFINITY;
        int wDist = INFINITY;
        for (int i = 0; i < graph.V(); i++) {
            vDist = bdpV.distTo(i);
            wDist = bdpW.distTo(i);
            if (vDist != INFINITY && wDist != INFINITY && len > vDist + wDist)
                len = vDist + wDist;
        }
        if (len != INFINITY)
            return len;
        else 
            return -1;
    }
    
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths bdpV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bdpW = new BreadthFirstDirectedPaths(graph, w);
        int len = INFINITY;
        int ancestor = -1;
        int vDist = INFINITY;
        int wDist = INFINITY;
        for (int i = 0; i < graph.V(); i++) {
            vDist = bdpV.distTo(i);
            wDist = bdpW.distTo(i);
            if (vDist != INFINITY && wDist != INFINITY && len > vDist + wDist) {
                len = vDist + wDist;
                ancestor = i;
            }
        }
        return ancestor;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        In in = new In("digraph1.txt");
//        In in = new In("C:\\Users\\c0kalla\\Documents\\workspace\\Example\\Algos\\src\\digraph1.txt");
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        l1.add(9);
        l1.add(7);
        l2.add(12);
        l2.add(2);
        System.out.print("vals: 3 and 11, ");
        System.out.println("length = " + sap.length(3, 11) + ", ancestor = "+ sap.ancestor(3, 11));
        System.out.print("vals: 9 and 12, ");
        System.out.println("length = " + sap.length(9, 12) + ", ancestor = "+ sap.ancestor(9, 12));
        System.out.print("vals: 7 and 2, ");
        System.out.println("length = " + sap.length(7, 2) + ", ancestor = "+ sap.ancestor(7, 2));
        System.out.print("vals: 6 and 1, ");
        System.out.println("length = " + sap.length(6, 1) + ", ancestor = "+ sap.ancestor(6, 1));
        
        System.out.print("vals: 9, 7 and 12, 2, ");
        System.out.println("length = " + sap.length(l1, l2) + ", ancestor = "+ sap.ancestor(l1, l2));
    }

}
