package list;

public class LinkList {

	//Remove duplicates from unsorted Link list;
	
	private Node head;
	
	public boolean isEmpty()
	{ return head == null; }
	public void push(String item)
	{
	Node oldhead = head;
	head = new Node();
	head.item = item;
	head.next = oldhead;
	}
	public String pop()
	{
	String item = head.item;
	head = head.next;
	return item;
	}
	
	
	class Node {
		private Node() {
			
		}
		private Node(String s) {
			this.item = s;
		}
		
		String item;
		Node next;
	}
}
