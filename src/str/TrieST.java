package str;

import edu.princeton.cs.algs4.Queue;


public class TrieST<Value> {

	private static final int R = 256;
	private Node root = new Node();
	
	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}
	
	private Node put(Node x, String key, Value val, int d) {
		if(null == x) 
			x = new Node();
		if(d == key.length())
			x.val = val;
		else {
			char c = key.charAt(d);
			x.next[c] = put(x.next[c], key, val, d + 1);
		}
		return x;
	}
	
	
	public Value get(String key) {
		Node x = get(root, key, 0);
		if(null == x)
			return null;
		else
			return (Value) x.val;
	}
	
	private Node get(Node x, String key, int d) {
		if(null == x)
			return null;
		if(d == key.length()) 
			return x;
		return get(x.next[key.charAt(d)], key, d + 1);
	}
	
	
	public void delete(String key) {
		root = delete(root, key, 0);
	}
	
	private Node delete(Node x, String key, int d) {
		if(null == x)
			return x;
		if(d == key.length())
			x.val = null;
		else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}
		
		if(x.val != null)
			return x;
		for(char c = 0; c < R; c++) 
			if(x.next[c] != null)
				return x;
		
		return null;
	}
	
	
	public Iterable<String> keys() {
		return keysWithPrefix("");
	}
	
	public Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> q = new Queue<String>();
		collect(get(root, prefix, 0), prefix, q);
		return q;
	}
	
	private void collect(Node x, String pre, Queue<String> q) {
		if(null == x)
			return;
		if(null != x.val)
			q.enqueue(pre);
		for(char c = 0; c < R; c++)
			collect(x.next[c], pre+c, q);
	}
	
	
	public String longestPrefixOf(String s) {
		int length = search(root, s, 0, 0);
		return s.substring(0, length);
	}
	
	
	private int search(Node x, String s, int d, int length) {
		if(null == x) 
			return length;
		if(null != x.val)
			length = d;
		if(d == s.length())
			return length;
		char c = s.charAt(d);
		return search(x.next[c], s, d + 1, length);
	}
	
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(x == null)
			return 0;
		int count = 0;
		if(null != x.val)
			count++;
		for(char c = 0; c < R; c++)
			count += size(x.next[c]);
		return count;
	}
	
	private static class Node {
		private Object val = null;
		private Node[] next = new Node[R];
	}
	

}
