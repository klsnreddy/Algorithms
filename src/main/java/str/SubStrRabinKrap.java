package str;

public class SubStrRabinKrap {

	private static final int R = 256;
	private String pat;
	private int hash;
	private int Q;
	private int RM;
	
	public SubStrRabinKrap(String pat) {
		this.pat = pat;
		this.Q = 993; //assign some prime number
		RM = 1;
		for(int i = 1; i < pat.length(); i++)
			RM = (RM * R) % Q;
		this.hash = hash(pat, pat.length());
	}

	public int search(String text) {
		int i, N = text.length();
		int j, M = pat.length();

		if(M > N)
			return -1;
		
		int localHash = hash(text, M);
		
		if(localHash == this.hash)
			return 0;
		
		for(i = M; i < N; i++) {
			localHash = (localHash + Q - text.charAt(i - M) * RM % Q) % Q; 
			localHash = (localHash * R + text.charAt(i)) % Q;
			if(localHash == hash)
				return i - M + 1;
		}

		return -1;
	}
	
	private int hash(String str, int length) {
		int hash = 0;
		
		for(int i = 0; i < length; i++) {
			hash = hash * R + str.charAt(i);
			hash %= Q;
		}
		
		return hash;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pat = "yer";
		String txt = "SubStrBoyerMooreSubStrBoyerMoore";
		SubStrRabinKrap bm = new SubStrRabinKrap(pat);
		
		int i = bm.search(txt);
		System.out.println(i);
		if(i >= 0)
			System.out.println(txt.substring(i, i += pat.length()));
		else
			System.out.println("No Match found");

	}

}
