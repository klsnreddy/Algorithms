package graph;

public class Cycle {

	private boolean[] marked = null;
	private boolean hasCycle;
	
	
	public Cycle(Graph g) {
		this.marked = new boolean[g.V()];
		for(int s = 0; s < g.V(); s++)
			if(!this.marked[s])
				dfs(g, s, s);
	}


	private void dfs(Graph g, int s, int u) {
		marked[s] = true;
		for(int v : g.adj(s))
			if(!marked[v])
				dfs(g, v, s);
			else if(v != u)
				hasCycle = true;
		
	}
	
	public boolean hasCycle() {
		return hasCycle;
	}
	
}
