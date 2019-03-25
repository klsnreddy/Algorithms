package graph;

/**
 * This is for DiGraph
 * to implement Depth first search
 * @author c0kalla
 *
 */
public class DepthFirstSearch {

	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public DepthFirstSearch(DiGraph g, int s) {
		this.marked = new boolean[g.V()];
		this.edgeTo = new int[g.V()];
		this.s = s;
		dfs(g, s);
	}
	
	public void dfs(DiGraph g, int v) {
		this.marked[v] = true;
		for(int w : g.adj(v)) {
			if(!this.marked[w]) {
				dfs(g, w);
				this.edgeTo[w] = v;
			}
		}
	}

	public boolean visited(int v) {
		return marked[v];
	}
	
	
}
