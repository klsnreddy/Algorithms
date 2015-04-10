package str;

public class SubStrBruteForce {

	
	public static int getMatch(String text, String pat) {
		int N = text.length(), M = pat.length();
		
		for(int i = 0; i <= N - M; i++) {
			int j = 0;
			for(; j < M; j++) {
				if(text.charAt(i + j) != pat.charAt(j))
					break;
			}
			if(j == M)
				return i;
		}
		
		return -1;
	}
	
	public static int getMatchSingleLoop(String text, String pat) {
		int N = text.length(), M = pat.length();
		int i, j;
		for(i = 0, j = 0; i < N && j < M; i++) {
			if(text.charAt(i) == pat.charAt(j))
				j++;
			else {
				i -= j;
				j = 0;
			}
		}
		if(j == M)
			return i - M;
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getMatch("shellsort", "ort"));
		System.out.println(getMatchSingleLoop("shellsort", "ot"));
		

	}

}
