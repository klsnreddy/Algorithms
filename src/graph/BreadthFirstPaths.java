package graph;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class BreadthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public BreadthFirstPaths(Graph g, int s) {
		this.s = s;
		this.marked = new boolean[g.V()];
		this.edgeTo = new int[g.V()];
		bfs(g, s);
	}
	
	public void bfs(Graph g, int v) {
		this.marked[v] = true;
		Queue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		queue.add(v);
		while(!queue.isEmpty()) {
			int q = queue.poll();
			for(int w : g.adj(q)) {
				if(!this.marked[w]) {
					queue.add(w);
					this.edgeTo[w] = q;
					this.marked[w] = true;
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return this.marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) 
			return null;
		Stack<Integer> stack = new Stack<Integer>();
		while(this.edgeTo[v] != s) {
			stack.add(this.edgeTo[v]);
			v = this.edgeTo[v];
		}
		stack.add(s);
		return stack;
	}
}
