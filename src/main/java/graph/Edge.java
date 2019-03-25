package graph;

public class Edge implements Comparable<Edge> {

	private int v;
	private int w;
	private double weight;
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight() {
		return weight;
	}
	
	public int either() {
		return v;
	}
	
	public int other(int v) {
		if(this.v == v)
			return w;
		return v;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(v).append("=").append(w).append("=").append(weight);
		return sb.toString();
	}
	
	public int compareTo(Edge e) {
		return Double.valueOf(weight).compareTo(e.weight());
	}

}
