package sort;

/**
 * 7/15/2014
 * @author Kallam
 * 
 * Shell sort is the basic sorting mechanism.
 * Generate the shell ranges using a formula and start with the highest value of the list.
 * Iterate in the range of shell values and compare the elements and exchange if required.
 * decrease the shell value and iterate the save way till we reach the shell value to 1 (means comparing adjacent elements).
 * 
 * Quadratic time algorithm.
 * Takes around ~N^(3/2) cycles.
 * 		Slightly better than the Insertion/Selection sort.
 *
 */
public class ShellSort {

	public static void sort(Comparable[] a) {
		int size = a.length;
		int h = 1;
		while (h < size/3) h = 3 * h + 1;
		
		while (h >= 1) {
			for (int i = h; i < size; i++) {
				for (int j = i; j >= h && less(a[j], a[j-h]); j-=h)
					exch(a, j, j-h);
			}
			h /= 3;
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
