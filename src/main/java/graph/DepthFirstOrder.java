package graph;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class DepthFirstOrder {

	private boolean[] marked;
	private Stack<Integer> reversePost;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	
	DepthFirstOrder(DiGraph g) {
		marked = new boolean[g.V()];
		pre = new ArrayBlockingQueue<Integer>(0);
		post = new ArrayBlockingQueue<Integer>(0);
		reversePost = new Stack<Integer>();
		for(int v=0; v < g.V(); v++) {
			if(!marked[v])
				dfs(g, v);
		}
	}
	
	private void dfs(DiGraph g, int v) {
		pre.add(v);
		marked[v] = true;
		for(int w : g.adj(v)) {
			if(!marked[w])
				dfs(g, w);
		}
		post.add(v);
		reversePost.add(v);
	}
	
	public Iterable<Integer> pre() {
		return pre;
	}
	
	public Iterable<Integer> post() {
		return post;
	}
	
	public Iterable<Integer> reversePost() {
		return reversePost;
	}
}
