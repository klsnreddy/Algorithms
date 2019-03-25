package graph;

import java.util.List;

public class DirectedDFS {

	
	private boolean[] marked;
	
	public DirectedDFS(DiGraph g, int s) {
		this.marked = new boolean[g.V()];
		dfs(g, s);
	}
	
	public DirectedDFS(DiGraph g, List<Integer> s) {
		this.marked = new boolean[g.V()];
		for(int v : s)
			if(!marked[v])
				dfs(g, v);
	}
	
	private void dfs(DiGraph g, int s) {
		this.marked[s] = true;
		for(int w : g.adj(s))
			if(!marked[w])
				dfs(g, w);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
