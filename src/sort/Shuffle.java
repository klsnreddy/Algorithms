package sort;

/**
 * 7/15/2014
 * @author Kallam
 * 
 * Shuffle the numbers or deck of cards.
 * Shuffling and Random number generation are very very hard.
 *
 */
public class Shuffle {

	public static void sort(Comparable[] a) {
		int size = a.length;
		
		for (int i = 0; i < size; i++) {
			int r = 0;//StdRandom.uniform(i+1); import StdRandom
			exch(a, i, r);
		}
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
