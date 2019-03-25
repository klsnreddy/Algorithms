package graph;

import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

public class Graph {

	private final int V;
	private int E;
	private List<Integer>[] adj;
	
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (List<Integer>[]) new List[V];
		for(int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Integer>();
		}
	}
	
	public Graph(In in) {
		this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}


}
