package stack.queue;

import java.util.Arrays;

public class ResizingArrayQueue {

	private Object[] queue;
	private int head, tail, N;
	
	public ResizingArrayQueue() {
		queue = new Object[1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public boolean isFull() {
		return N == queue.length;
	}
	
	public void enqueue(Object o) {
		if(null == o);
			//throw new Exception();
		if(isFull()) 
			resize(2*queue.length);
		queue[tail++] = o;
		if(tail==queue.length) tail = 0;
		N++;
	}
	
	public Object dequeue() {
		Object o = null;
		if(isEmpty());
			//throw new Exception();
		else {
			o = queue[head];
			queue[head++] = null;
			if(N>0 &&  N==queue.length/4)
				resize(queue.length/2);
		}
		N--;
		if(head==queue.length) head = 0;
		return o;
	}
	
	private void resize(int capacity) {
		System.out.println("resizing");
		Object[] copy = new Object[capacity];
		int j = head;
		for(int i=0; i<N; i++) {
			copy[i] = queue[j++];
			j%=queue.length;
		}
		queue = copy;
		head = 0;
		tail = N;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ResizingArrayQueue q = new ResizingArrayQueue();
		q.enqueue(1);
		System.out.println(Arrays.toString(q.queue));
		q.enqueue(2);
		System.out.println(Arrays.toString(q.queue));
		q.enqueue(3);
		System.out.println(Arrays.toString(q.queue));
		System.out.println(q.dequeue());
		System.out.println(Arrays.toString(q.queue));
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(Arrays.toString(q.queue));
		System.out.println(q.dequeue());
		System.out.println(Arrays.toString(q.queue));
		q.enqueue(6);
		q.enqueue(7);
		System.out.println(Arrays.toString(q.queue));
	}

}
