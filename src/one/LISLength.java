package one;


public class LISLength {

	
	public int ls(int[] arr) {
		int max = 0;
		int[] temp = new int[arr.length];

		for(int i = 0; i < temp.length; i++) 
			temp[i] = 1;

		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && temp[i] < temp[j] + 1)
					temp[i] = temp[j] + 1;
			}
		}
		
		for(int i = 0; i < temp.length; i++)
			if(temp[i] > max)
				max = temp[i];
		
		return max;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LISLength lis = new LISLength();
		int[] source = {10, 22, 9, 33, 21, 50, 41, 60, 55, 56 };
		int len = lis.ls(source);
		System.out.println(len);

	}

}
