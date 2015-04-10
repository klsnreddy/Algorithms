package graph;

public class Topological {

	private Iterable<Integer> order;
	
	public Topological(DiGraph g) {
		DirectedCycle finder = new DirectedCycle(g);
		if(!finder.hasCycle()) {
			DepthFirstOrder dfo = new DepthFirstOrder(g);
			order = dfo.reversePost();
		}
	}
	
	public Iterable<Integer> order() {
		return order;
	}
	
	public boolean hasOrder() {
		return order != null;
	}

}
