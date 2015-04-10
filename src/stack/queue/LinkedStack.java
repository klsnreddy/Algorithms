package stack.queue;

public class LinkedStack {

	private Node first;
	
	private class Node {
		private Object item;
		private Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	
	public void push(Object o) {
		if(null == o);
			//throw new Exception();
		Node temp = new Node();
		temp.item = o;
		temp.next = first;
		first = temp;
	}
	
	public Object pop() {
		Object o = null;
		if(first == null);
			//throw new Exception();
		else {
			o = first.item;
			first = first.next;
		}
		return o;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
