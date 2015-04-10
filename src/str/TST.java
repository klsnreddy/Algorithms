package str;

public class TST<Value> {

	private Node root = null;
	
	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}
	
	private Node put(Node x, String key, Value val, int d) {
		
		char c = key.charAt(d);
		
		if(null == x) {
			x = new Node();
			x.c = c;
		}
		
		if(c < x.c)
			x.left = put(x.left, key, val, d);
		else if(c > x.c)
			x.right = put(x.right, key, val, d);
		else if(d < key.length() - 1)
			x.mid = put(x.mid, key, val, d + 1);
		else
			x.val = val;
		
		return x;
	}
	
	public Value get(String key) {
		Node x = get(root, key, 0);
		if(null != x)
			return x.val;
		return null;
	}
	
	private Node get(Node x, String key, int d) {
		if(null == x)
			return null;
		
		char c = key.charAt(d);
		if(c < x.c)
			return get(x.left, key, d);
		else if(c > x.c)
			return get(x.right, key, d);
		else if(d < key.length() - 1)
			return get(x.mid, key, d + 1);

		return x;
	}
	
	private class Node {
		private char c;
		private Value val;
		private Node left, mid, right;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
