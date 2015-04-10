package union.find;

import java.util.Arrays;

public class QuickFindUF {

	private int[] id;
	
	public QuickFindUF(int N) {
		id = new int[N];
		for(int i=0; i< N; i++) {
			id[i] = i;
		}
	}
	
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public void union(int p, int q) {
		if(!connected(p, q)) {
			int pId = id[p];
			int qId = id[q];
			
			for(int i=0; i< id.length; i++) {
				if(id[i] == pId) {
					id[i] = qId;
				}
			}
		} else {
			System.out.println("elements "+p+" and "+q+" are already connected");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuickFindUF qUF = new QuickFindUF(10);
		System.out.println(Arrays.toString(qUF.id));
		
		qUF.union(1, 5);
		qUF.union(1, 8);
		qUF.union(2, 9);
		qUF.union(4, 7);
		qUF.union(2, 9);
		
		System.out.println(Arrays.toString(qUF.id));
	}

}
