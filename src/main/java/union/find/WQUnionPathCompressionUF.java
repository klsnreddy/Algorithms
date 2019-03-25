package union.find;

import java.util.Arrays;

public class WQUnionPathCompressionUF {

	private int[] id;
	private int[] size;
	
	public WQUnionPathCompressionUF(int N) {
		id = new int[N];
		size = new int[N];
		for(int i=0; i< N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	public int root(int i) {
		while(id[i] != i) {
			id[i] = id[id[i]]; //***Change ......... Chaining to Grand parent.
			i = id[i];
		}
		return i;
	}
	
	//***Change .... Pointing every element from p to root to root directly.
	/*public int root(int i) {
		int p = i;
		int t = i;
		
		while(id[i] != i) {
			id[i] = id[id[i]]; 
			i = id[i];
		}
		
		while(id[p] != i) {
			t = p;
			p = id[p];
			id[t] = i;
		}
		
		return i;
	}*/
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {

		int pRoot = root(p);
		int qRoot = root(q);
		if(pRoot == qRoot) return;
		
		if(size[pRoot] > size[qRoot]) {
			id[qRoot] = pRoot;
			size[pRoot] += size[qRoot];
		} else {
			id[pRoot] = qRoot;
			size[qRoot] += size[pRoot];
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WQUnionPathCompressionUF wqUF = new WQUnionPathCompressionUF(10);
		System.out.println(Arrays.toString(wqUF.id));
		
		wqUF.union(1, 5);
		wqUF.union(1, 8);
		wqUF.union(2, 9);
		wqUF.union(4, 7);
		wqUF.union(2, 9);
		
		System.out.println(Arrays.toString(wqUF.id));

	}

}
