package str;

public class SubStrKnuthMorrisPratt {

	private static final int R = 256;
	private String pat;
	private int[][] dfa;
	
	public SubStrKnuthMorrisPratt(String pat) {
		this.pat = pat;
		this.dfa = new int[R][pat.length()];
		
		dfa[pat.charAt(0)][0] = 1;
		
		int x = 0;
		for (int i = 1; i < pat.length(); i++) {
			
			for(int c = 0; c < R; c++)
				dfa[c][i] = dfa[c][x];
			dfa[pat.charAt(i)][i] = i + 1;
			x = dfa[pat.charAt(i)][x];
		}
	}
	
	
	public int search(String txt) {
		int N = txt.length();
		int M = pat.length();
		if(N < M)
			return -1;
		int state, i;
		
		for(i = 0, state = 0; i < N && state < M; i++) 
			state = dfa[txt.charAt(i)][state];
		
		if(state == M)
			return i - M;
		return -1;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pat = "nut";
		String txt = "SubStrKnuthMorrisPrattSubStrKnuthMorrisPratt";
		SubStrKnuthMorrisPratt kmp = new SubStrKnuthMorrisPratt(pat);
		
		int i = 0;
		
		while(i != -1) {
			i = kmp.search(txt = txt.substring(i));
			System.out.println(i);
			if(i >= 0)
				System.out.println(txt.substring(i, i += pat.length()));
			else
				System.out.println("No Match found");
		}

	}

}
