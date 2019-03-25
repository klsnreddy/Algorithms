package graph;

public class GraphUtil {

	public static int degree(Graph g, int v) {
		int degree = 0;
		for(int w : g.adj(v))
			degree++;
		return degree;
	}
	
	public static int maxDegree(Graph g) {
		int max = 0;
		int degree = 0;
		for(int i =0; i < g.V(); i++) {
			degree = degree(g, i);
			if(degree > max)
				max = degree;
		}
		return max;
	}
	
	public static double averageDegree(Graph g) {
		return 2.0 * g.E() / g.V();
	}
	
	public static int numberOfSelfLoops(Graph g) {
		int selfLoops = 0;
		for(int i =0; i < g.V(); i++) {
			for(int w : g.adj(i)) {
				if(i == w)
					selfLoops ++;
			}
		}
		return selfLoops;
	}

}
