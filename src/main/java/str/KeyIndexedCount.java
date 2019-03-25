package str;

import java.util.Arrays;

public class KeyIndexedCount {

	private static int[] sort(int[] a) {
		int[] aux = new int[a.length];
		int R = 6;
		int[] count = new int[R+1];
		
		//count the number items fall at that specific key.
		for(int i=0; i<a.length; i++) {
			count[a[i] - 'a' + 1]++;
		}
		
		//count the cumulative numbers of the key counts.
		for(int i=0; i<R; i++) {
			count[i+1] += count[i];
		}
		
		//place the elements in the aux array based on the cumulative counts.
		for(int i=0; i<a.length; i++) {
			aux[count[a[i] - 'a']++] = a[i];
		}
		
		//copy the keys from aux to original array
		for(int i=0; i<a.length; i++) {
			a[i] = aux[i];
		}
		return a;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {'a','b','c','a','f','e','d','d','f','b','e','b','f','c'};
		a = sort(a);
		System.out.println(Arrays.toString(a));
	}

}
