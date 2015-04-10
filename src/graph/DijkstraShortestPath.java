package graph;

import java.util.Arrays;
import java.util.Stack;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.introcs.In;

public class DijkstraShortestPath {

	private EdgeWeightedDiGraph G = null;
	private int s;
	private double[] distTo = null;
	private IndexMinPQ<Double> pq = null;
	private DirectedEdge[] pathTo = null;
	
	public DijkstraShortestPath(EdgeWeightedDiGraph graph, int source) {
		this.G = graph;
		this.s = source;
		this.distTo = new double[G.V()];
		this.pathTo = new DirectedEdge[G.V()];
		
		for(int i = 0; i < distTo.length; i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		
		pq = new IndexMinPQ<Double>(G.V());
		pq.insert(s, 0.0);
		
		while(!pq.isEmpty()) {
			int v = pq.delMin();
			for(DirectedEdge e : G.adj(v)) {
				relax(e);
			}
		}
	}
	
	
	
	private void relax(DirectedEdge e) {
		if(distTo[e.to()] > distTo[e.from()] + e.weight()) {
			distTo[e.to()] = distTo[e.from()] + e.weight();
			pathTo[e.to()] = e;
			if(pq.contains(e.to()))
				pq.decreaseKey(e.to(), distTo[e.to()]);
			else
				pq.insert(e.to(), distTo[e.to()]);
		}
	}

	public double distTo(int v) {
		return this.distTo[v];
	}
	
	public Iterable<DirectedEdge> pathTo(int v) {
		Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
		for(DirectedEdge e = pathTo[v]; e != null; e = pathTo[e.from()])
			stack.push(e);
		return stack;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EdgeWeightedDiGraph graph = new EdgeWeightedDiGraph(new In("C:\\Users\\c0kalla\\Documents\\workspace\\Example\\Algos\\src\\tiny.txt"));
		DijkstraShortestPath stp = new DijkstraShortestPath(graph, 0);
		System.out.println(Arrays.toString(stp.distTo));
	}

}
