package union.find;

import java.util.Arrays;

public class QuickUnionUF {

private int[] id;
	
	public QuickUnionUF(int N) {
		id = new int[N];
		for(int i=0; i< N; i++) {
			id[i] = i;
		}
	}
	
	public int root(int i) {
		while(id[i] != i) {
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {

		int pRoot = root(p);
		int qRoot = root(q);
		
		id[pRoot] = qRoot;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuickUnionUF qUF = new QuickUnionUF(10);
		System.out.println(Arrays.toString(qUF.id));
		
		qUF.union(1, 5);
		qUF.union(1, 8);
		qUF.union(2, 9);
		qUF.union(4, 7);
		qUF.union(2, 9);
		
		System.out.println(Arrays.toString(qUF.id));

	}

}
