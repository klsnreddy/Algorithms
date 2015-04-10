package graph;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.MinPQ;

public class MinimumSpanningTreeEager {

	private double weight;
	private List<Edge> mst;
	boolean[] marked;
	MinPQ<Edge> queue;
	
	public MinimumSpanningTreeEager(EdgeWeightedGraph g) {
		marked = new boolean[g.V()];
		queue = new MinPQ<Edge>();
		mst = new ArrayList<Edge>();
		visit(0, g.adj(0));
		while(!queue.isEmpty()) {
			Edge e = queue.delMin();
			int v = e.either();
			if(marked[v] && marked[e.other(v)])
				continue;
			weight += e.weight();
			mst.add(e);
			if(mst.size() == g.V() - 1)
				break;
			
			if(marked[v])
				visit(e.other(v), g.adj(e.other(v)));
			else
				visit(v, g.adj(v));
		}
		queue = null;
		marked = null;
	}
	
	private void visit(int v, Iterable<Edge> edges) {
		marked[v] = true;
		for(Edge e : edges) {
			if(!marked[e.other(v)])
				queue.insert(e);
		}
	}
	
	public Iterable<Edge> edges() {
		return mst;
	}
	
	public double weight() {
		return weight;
	}

}
