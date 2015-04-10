package stack.queue;

public class ResizingArrayStack {

	private Object[] stack;
	private int N;
	
	public ResizingArrayStack() {
		stack = new Object[1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(Object o) {
		if(null == o);
			//throw new Exception();
		if(N == stack.length) 
			resize(2*N);
		stack[N++] = o;
	}
	
	public Object pop() {
		Object o = null;
		if(isEmpty());
			//throw new Exception();
		else {
			o = stack[--N];
			stack[N] = null;
			if(N>0 &&  N==stack.length/4)
				resize(stack.length/2);
		}
		return o;
	}
	
	private void resize(int capacity) {
		Object[] copy = new Object[capacity];
		for(int i=0; i<N; i++) 
			copy[i] = stack[i];
		stack = copy;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
