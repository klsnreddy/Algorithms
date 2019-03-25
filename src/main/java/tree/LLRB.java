package tree;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class LLRB<Key extends Comparable<Key>, Value> {

	private Node root;
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
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
	
	private Node put(Node h, Key key, Value val) {
		if(h == null) return new Node(key, val, RED);
		
		int comp = key.compareTo(h.key);
		if(comp < 0) h.left = put(h.left, key, val);
		else if(comp > 0) h.right = put(h.right, key, val);
		else h.val = val;
		
		if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.left) && isRed(h.right)) h= flipColors(h);
		
		h.count = 1 + size(h.left) + size(h.right); //To populate the count and will be 
													//recursively. ????? And need to check in this class.
		return h;
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
	
	private Node rotateLeft(Node h) {
		assert isRed(h.right);
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private Node rotateRight(Node h) {
		assert isRed(h.left);
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private Node flipColors(Node h) {
		assert !isRed(h);
		assert isRed(h.left);
		assert isRed(h.right);
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
		return h;
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
	
	private boolean isRed(Node x) {
		if(null == x)
			return false;
		return x.color;
	}
	
	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int count; //Number of nodes in subtree.
		private boolean color; //To denote the color in Red-Black tree.
		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
		
		public Node(Key key, Value val, boolean color) {
			this.key = key;
			this.val = val;
			this.color = color;
		}
	}
}

