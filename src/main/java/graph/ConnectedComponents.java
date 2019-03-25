package graph;

public class ConnectedComponents {

	private int[] cc;
	private boolean[] marked;
	private int count;
	
	public ConnectedComponents(Graph g) {
		this.count = 0;
		this.cc = new int[g.V()];
		this.marked = new boolean[g.V()];
		for(int v = 0; v< g.V(); v++) {
			if(!this.marked[v]) {
				dfs(g, v);
				count++;
			}
		}
	}
	
	private void dfs(Graph g, int v) {
		this.marked[v] = true;
		this.cc[v] = count;
		for(int w : g.adj(v)) {
			if(!this.marked[w]) {
				dfs(g, w);
			}
		}
	}
	
	public boolean connected(int v, int w) {
		return id(v) == id(w);
	}
	
	public int count() {
		return count;
	}
	
	public int id(int v) {
		return cc[v];
	}

}
