package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.In;

public class EdgeWeightedDiGraph {

	private final int V;
	private int E;
	private List<DirectedEdge>[] adj;
	
	public EdgeWeightedDiGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (List<DirectedEdge>[]) new List[V];
		for(int v = 0; v < V; v++) {
			adj[v] = new LinkedList<DirectedEdge>();
		}
	}
	
	public EdgeWeightedDiGraph(In in) {
		this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
	}
	
	public void addEdge(DirectedEdge e) {
		adj[e.from()].add(e);
		E++;
	}
	
	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}
	
	public Iterable<DirectedEdge> edges() {
		List<DirectedEdge> edges = new ArrayList<DirectedEdge>();
		for(int i=0; i < V; i++) {
			for(DirectedEdge e : adj(i)) 
				edges.add(e);
		}
		return edges;
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}


}
