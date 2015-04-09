package str.arr;

public class SpaceReplace {


	private static String repSpace(String s) {
		char[] con = s.toCharArray();
		int len = con.length;
		boolean last = true;
		int count = 0;
		for(int i=len-1; i>=0; i--) {
			if(con[i] == ' ') {
				if(last)
					continue;
				con[--len] = '0';
				con[--len] = '2';
				con[--len] = '%';
				count++;
			} else {
				last = false;
				con[--len] = con[i];
			}
		}
		String str = new String(con);
		System.out.println(str.length()-(count*2));
		return str;
	}
	
	public static void main(String[] args) {
		String s = repSpace("Mr Dohn Smith    ");
		System.out.println(s);
	}

}
