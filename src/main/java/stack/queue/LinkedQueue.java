package stack.queue;

public class LinkedQueue {

	private Node first;
	private Node last;
	
	private class Node {
		private Object item;
		private Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	
	public void enqueue(Object o) {
		if(null == o);
			//throw new Exception();
		Node oldLast = last;
		last = new Node();
		last.item = o;
		if(isEmpty())
			first = last;
		else
			oldLast.next = last;
	}
	
	public Object dequeue() {
		Object o = null;
		if(isEmpty());
			//throw new Exception();
		else {
			o = first.item;
			first = first.next;
		}
		
		if(isEmpty())
			last = null;
		
		return o;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
