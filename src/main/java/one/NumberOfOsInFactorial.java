package one;

public class NumberOfOsInFactorial {

	private static int numberOfZeros(int n) {
		int count = 0;
		int i = 5;
		while(i <= n) {
			count += n/i;
			i *= 5;
		}
		
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 1000;
		System.out.println(numberOfZeros(n));
	}

}
