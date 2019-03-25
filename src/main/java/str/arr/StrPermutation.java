package str.arr;

import java.util.Arrays;

public class StrPermutation {

	//Better solution
	private static boolean isPermutation(String one, String two) {
		if(one.length() != two.length())
			return false;
		int[] letters = new int[256];
		
		char[] _array = one.toCharArray();
		for(char c: _array){
			letters[c]++;
		}
		
		for(int i=0; i<two.length(); i++) {
			int c = two.charAt(i);
			if(--letters[c] < 0)
				return false;
		}
		return true;
	}
	
	//Good solution
	private static boolean isPermu(String one, String two) {
		if(one.length() != two.length())
			return false;
		return sort(one).equals(sort(two));
	}
	
	private static String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static void main(String[] args) {

		String one = "";
		String two = "";
		boolean permu = isPermutation(one, two);
	}

}
