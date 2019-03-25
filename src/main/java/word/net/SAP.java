package word.net;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

public class SAP {

	
	public SAP(Digraph G) {
		
	}
	
	public int length(int v, int w) {
		return 0;
	}
	
	public int ancestor(int v, int w) {
		return 0;
	}
	
	public int length(Iterable<Integer> v, Iterable<Integer> w) {
		return 0;
	}
	
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		return 0;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In("digraph1.txt");
	    Digraph G = new Digraph(in);
	    SAP sap = new SAP(G);
	    System.out.println(G.toString());
	}

}
