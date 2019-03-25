package sort;

/**
 * 7/15/2014
 * @author Kallam
 * 
 * Selection sort is the basic sorting mechanism.
 * The elements to the left of the pointer are sorted.
 * The elements to the right of the pointer are not sorted (but visited).
 * The elements to the left of the pointer are less (depending on the sorting order) than 
 * 		the elements to the right of the pointer.
 * Compare the pointer element with the elements to it's right,
 * 		determine the minimum element and exchange it with the pointer.
 * 
 * Quadratic time algorithm.
 * Takes around ~(N^2)/2 cycles.
 *
 */
public class SelectionSort {

	public static void sort(Comparable[] a) {
		int size = a.length;
		int min = 0;
		for (int i = 0; i < size; i++) {
			min = i;
			for (int j = i+1; j < size; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}
	
	private static boolean less(Comparable val1, Comparable val2) {
		return val1.compareTo(val2) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
