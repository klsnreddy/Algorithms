package str;

import java.util.Arrays;

public class LSDRadixSort {

	public static void sort(String[] a, int W) {
		int R = 256;
		String[] aux = new String[a.length];
		
		for(int d = W - 1; d >= 0; d--) {
			int[] count = new int[R+1];
			
			//count the number items fall at that specific key.
			for(int i=0; i<a.length; i++) {
				count[a[i].charAt(d) + 1]++;
			}
			
			//count the cumulative numbers of the key counts.
			for(int i=0; i<R; i++) {
				count[i+1] += count[i];
			}
			
			//place the elements in the aux array based on the cumulative counts.
			for(int i=0; i<a.length; i++) {
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			
			//copy the keys from aux to original array
			for(int i=0; i<a.length; i++) {
				a[i] = aux[i];
			}
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = {"dab", "cab", "fad", "bad", "dad", "ebb", "ace", "add", "fed", "bed", "fee", "bee"};
		sort(a, 3);
		System.out.println(Arrays.toString(a));

	}

}
