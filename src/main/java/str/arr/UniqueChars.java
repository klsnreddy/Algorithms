package str.arr;

public class UniqueChars {

	
	//Better Solution
	//making the bit at the position of the character to 1 by "checker |= (1 << val)"
	//and checking whether that position is converted to 1 already by "(checker & (1 << val)) > 0"
	private static boolean isUniqueChars(String one) {
		int checker =0;
		for(int i=0; i<one.length(); i++) {
			int val = one.charAt(i) - 'a';
			if((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	//Good solution
	private static boolean isUniqueChars2(String one) {
		if(one.length() > 256)
			return false;
		boolean[] char_set = new boolean[256];
		for(int i=0; i<one.length(); i++) {
			int val = one.charAt(i);
			if(char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	//Mine
	private static boolean check(String one) {
		boolean unique = true;
		int len = one.length();
		for(int i=0; i<len; i++) {
			char c = one.charAt(i);
			if(one.indexOf(c, i+1) > -1) {
				unique = false;
				break;
			}
		}
		return unique;
	}
	
	public static void main(String[] args) {
		String one = "asdfghijkll";
		boolean unique = check(one);
		System.out.println(unique);
		System.out.println(isUniqueChars2(one));
		System.out.println(isUniqueChars(one));
	}

}
