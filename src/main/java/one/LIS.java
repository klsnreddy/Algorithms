package one;

import java.util.Arrays;


public class LIS {

	
	public int[] ls(int[] arr) {
		int max = 0;
		int[] predecessor = new int[arr.length];
		int[] maxTracker = new int[arr.length + 1];
		
		
		for(int i = 0; i < arr.length; i++) {
			int lo = 1;
			int hi = max;
			while(lo <= hi) {
				int mid = (lo + hi)/2 + (lo + hi)%2;
				if(arr[maxTracker[mid]] < arr[i])
					lo = mid + 1;
				else
					hi = mid - 1;
			}
			int newMax = lo;
			predecessor[i] = maxTracker[newMax - 1];
			maxTracker[newMax] = i;
			
			if(newMax > max) {
				max = newMax;
			}
		}

		System.out.println(Arrays.toString(predecessor));
		System.out.println(Arrays.toString(maxTracker));
		
		int[] output = new int[max];
		for(int i = max - 1, k = maxTracker[max]; i >= 0; i--) {
			output[i] = arr[k];
			k = predecessor[k];
		}
		
		return output;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LIS lis = new LIS();
		int[] source = {10, 22, 9, 33, 21, 50, 41, 55, 60, 70, 80, 56, 57, 58 };
		int result[] = lis.ls(source);
		System.out.println(Arrays.toString(result));

	}

}
