package graph;

public class TwoColor {

	private boolean[] marked;
	private boolean[] colors;
	private boolean isTwoColorable = true;
	
	public TwoColor(Graph g) {
		this.marked = new boolean[g.V()];
		this.colors = new boolean[g.V()];
		for(int s = 0; s < g.V(); s++)
			if(!marked[s])
				dfs(g, s);
	}
	
	private void dfs(Graph g, int s) {
		marked[s] = true;
		
		for(int v : g.adj(s))
			if(!marked[v]) {
				colors[v] = !colors[s];
				dfs(g, v);
			} else if (colors[v] == colors[s]) {
				isTwoColorable = false;
			}
	}

	public boolean isBipartite() {
		return isTwoColorable;
	}

}
