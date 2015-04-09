package str.arr;

public class Compression {


	private static String compress(String s) {
		char[] con = s.toCharArray();
		char[] newCon = new char[con.length * 2];
		int p = 0;
		char count = 1;
		if(con.length > 0) {
			char c = con[0];
			
			for(int i=1; i<con.length; i++) {
				if(c == con[i]) {
					count++;
					continue;
				} else {
					newCon[p++] = c;
					newCon[p++] = count;
					c = con[i];
					count = 1;
				}
			}
			newCon[p++] = c;
			newCon[p++] = (char) count;
		}
		if(p == con.length * 2) {
			return s;
		}
		return new String(newCon);
	}
	
	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
		System.out.println(compress("abcd"));

	}

}
