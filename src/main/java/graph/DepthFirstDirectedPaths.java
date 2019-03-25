package graph;

import java.util.Stack;

public class DepthFirstDirectedPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public DepthFirstDirectedPaths(DiGraph g, int s) {
		this.marked = new boolean[g.V()];
		this.edgeTo = new int[g.V()];
		this.s = s;
		dfs(g, s);
	}
	
	private void dfs(DiGraph g, int v) {
		this.marked[v] = true;
		for(int w : g.adj(v)) {
			if(!this.marked[w]) {
				dfs(g, w);
				this.edgeTo[w] = v;
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
