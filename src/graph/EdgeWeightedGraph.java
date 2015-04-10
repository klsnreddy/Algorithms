package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.In;

public class EdgeWeightedGraph {

	private final int V;
	private int E;
	private List<Edge>[] adj;
	
	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (List<Edge>[]) new List[V];
		for(int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Edge>();
		}
	}
	
	public EdgeWeightedGraph(In in) {
		this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(v, w, weight));
        }
	}
	
	public void addEdge(Edge e) {
		int v = e.either();
		adj[v].add(e);
		adj[e.other(v)].add(e);
		E++;
	}
	
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}
	
	public Iterable<Edge> edges() {
		List<Edge> edges = new ArrayList<Edge>();
		for(int i=0; i < V; i++) {
			for(Edge e : adj(i)) {
				if(e.other(i) > i)
					edges.add(e);
			}
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
