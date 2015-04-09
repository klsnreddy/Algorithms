package tree;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BST<Key extends Comparable<Key>, Value> {

	private Node root;
	
	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int comp = key.compareTo(x.key);
			if(comp < 0) x = x.left;
			else if(comp > 0) x = x.right;
			else return x.val;
		}
		return null;
	}
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val) {
		if(x == null) return new Node(key, val);
		
		int comp = key.compareTo(x.key);
		if(comp < 0) x.left = put(x.left, key, val);
		else if(comp > 0) x.right = put(x.right, key, val);
		else x.val = val;
		x.count = 1 + size(x.left) + size(x.right); //To populate the count and will be 
													//recursively.
		return x;
	}
	
	public Key min() {
		Node x = min(root);
		if (null != x)
			return x.key;
		return null;
	}
	
	private Node min(Node x) {
		if(null == x.left) return x;
		return min(x.left);
	}
	
	public Key max() {
		Node x = max(root);
		if (null != x)
			return x.key;
		return null;
	}
	
	private Node max(Node x) {
		if(null == x.right) return x;
		return max(x.right);
	}
	
	public Key floor(Key key) {
		Node x = floor(root, key);
		if(null != x) 
			return x.key;
		return null;
	}
	
	private Node floor(Node x, Key key) {
		if(null == x) return null;
		
		int comp = key.compareTo(x.key);
		
		if(comp == 0) return x;
		
		if(comp < 0) 
			return floor(x.left, key);
		
		Node n = floor(x.right, key);
		if(null != n)
			return n;
		return x;
	}
	
	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if(null != x) 
			return x.key;
		return null;
	}
	
	private Node ceiling(Node x, Key key) {
		if(null == x) return null;
		
		int comp = key.compareTo(x.key);
		
		if(comp == 0) return x;
		
		if(comp > 0) 
			return ceiling(x.right, key);
		
		Node n = ceiling(x.left, key);
		if(null != n)
			return n;
		return x;
	}
	
	private int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(null != x) 
			return x.count;
		return 0;
	}
	
	public int rank(Key key) {
		return rank(root, key);
	}
	
	private int rank(Node x, Key key) {
		if(null == x) return 0;
		
		int comp = key.compareTo(x.key);
		
		if(comp == 0) return size(x);
		if(comp < 0) return rank(x.left, key);
		
		return 1 + size(x.left) + rank(x.right, key);
	}
	
	public Iterable<Key> keys() {
		Queue<Key> q = new ArrayBlockingQueue<Key>(10);
		inorder(root, q);
		return q;
	}
	
	private void inorder(Node x, Queue<Key> q) {
		if(null == x) return;
		inorder(x.left, q);
		q.add(x.key);
		inorder(x.right, q);
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		if(null == x.left) return x.right;
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	public Node delete(Node x, Key key) {
		if(null == x) return null;
		int comp = key.compareTo(x.key);
		
		if(comp < 0) x.left = delete(x.left, key);
		else if (comp > 0) x.right = delete(x.right, key);
		else {
			if(null == x.right) return x.left;
			if(null == x.left) return x.right;
			
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
		
	}
	
	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int count; //Number of nodes in subtree.
		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}
}
