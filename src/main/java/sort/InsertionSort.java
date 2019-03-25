package sort;

/**
 * 7/15/2014
 * @author Kallam
 * 
 * Insertion sort is the basic sorting mechanism.
 * The elements to the left of the pointer are sorted.
 * The elements to the right of the pointer are not sorted and not visited.
 * Compare the pointer element with the elements to it's left and exchange 
 * 		till it is greater than the immediate left element.
 * 
 * Quadratic time algorithm.
 * Takes around ~(N^2)/4 cycles.
 * 		Slightly better than the Selection sort (because not comparing with all the elements).
 *
 */
public class InsertionSort {

	public static void sort(Comparable[] a) {
		int size = a.length;
		for (int i = 0; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j-1])) {
					exch(a, j, j-1);
				} else {
					break;
				}
			}
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
