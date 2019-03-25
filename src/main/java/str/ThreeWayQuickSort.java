package str;

import java.util.Arrays;

public class ThreeWayQuickSort {

	
	public static void sort(String[] a) {
		sort(a, 0, a.length - 1, 0);
	}
	
	private static void sort(String[] a, int lo, int hi, int d) {
		
		if(hi <= lo)
			return;
		
		int lt = lo, gt = hi;
		int v = charAt(a[lo], d);
		int i = lo + 1;
		
		while(i <= gt) {
			int t = charAt(a[i], d);
			if(t < v)
				exch(a, lt++, i++);
			else if(t > v)
				exch(a, i, gt--);
			else 
				i++;
		}
		
		sort(a, lo, lt - 1, d);
		if(v >= 0) 
			sort(a, lt, gt, d + 1);
		sort(a, gt + 1, hi, d);
	}
	
	private static int charAt(String s, int d) {
		if(d < s.length())
			return s.charAt(d);
		return -1;
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
