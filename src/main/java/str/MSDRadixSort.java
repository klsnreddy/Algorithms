package str;

import java.util.Arrays;

public class MSDRadixSort {

	
	public static void sort(String[] a) {
		String[] aux = new String[a.length];
		sort(a, aux, 0, a.length-1, 0);
	}
	
	
	private static void sort(String[] a, String[] aux, int lo, int hi, int d) {
		
		if(hi <= lo)
			return;
		if(hi - lo <= 3) {
			insertionSort(a, lo, hi, d);
			return;
		}
		
		int R = 256;
		int[] count = new int[R+2];
		
		if(lo==1)
			System.out.println("");
		
		//count the number items fall at that specific key.
		for(int i = lo; i <= hi; i++) {
			count[charAt(a[i], d) + 2]++;
		}
		
		//count the cumulative numbers of the key counts.
		for(int i = 0; i < R + 1; i++) {
			count[i+1] += count[i];
		}
		
		//place the elements in the aux array based on the cumulative counts.
		for(int i = lo; i <= hi; i++) {
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		}
		
		//copy the keys from aux to original array
		for(int i = lo; i <= hi; i++) {
			a[i] = aux[i - lo];
		}
		
		for(int i = 0; i < R; i++) {
			sort(a, aux, lo + count[i], lo + count[i+1] - 1, d+1);
		}
	}
	
	private static int charAt(String s, int d) {
		if(d < s.length())
			return s.charAt(d);
		return -1;
	}
	
	private static void insertionSort(String[] a, int lo, int hi, int d) {
		for(int i = lo; i <= hi; i++) {
			for(int j = i; j > lo && less(a[j], a[j-1], d); j--) {
				exch(a, j, j-1);
			}
		}
	}
	
	private static boolean less(String v, String w, int d) {
		return v.substring(d).compareTo(w.substring(d)) < 0;
	}
	
	private static void exch(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = {"she", "sells", "seashells", "by", "the", "sea", "shore", "the", "shells", "she", "sells", "are", "surely", "seashells"};
		sort(a);
		System.out.println(Arrays.toString(a));
	}

}
