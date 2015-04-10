package str;

public class SubStrBoyerMoore {

	
	private static final int R = 256;
	private String pat;
	private int[] counter;
	
	public SubStrBoyerMoore(String pat) {
		this.pat = pat;
		counter = new int[R];
		
		for(int c = 0; c < R; c++) 
			counter[c] = -1;
		
		for(int i = 0; i < pat.length(); i++) 
			counter[pat.charAt(i)] = i;
	}

	public int search(String text) {
		int i, N = text.length();
		int j, M = pat.length();

		int skip = 0;
		for(i = 0; i <= N - M ; i += skip) {
			skip = 0;
			for (j = M - 1; j >= 0; j--) {
				if(text.charAt(i + j) != pat.charAt(j)) {
					skip = Math.max(1, j - counter[text.charAt(i + j)]);
					break;
				}
			}
			if(skip == 0)
				return i;
		}
		return -1;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pat = "yer";
		String txt = "SubStrBoyerMooreSubStrBoyerMoore";
		SubStrBoyerMoore bm = new SubStrBoyerMoore(pat);
		
		int i = bm.search(txt);
		System.out.println(i);
		if(i >= 0)
			System.out.println(txt.substring(i, i += pat.length()));
		else
			System.out.println("No Match found");

	}

}
