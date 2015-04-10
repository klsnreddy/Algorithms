package one;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSequence {

	private List<Integer> longestSequence(int[] arr) {
		if(null == arr || arr.length == 0)
			return null;
		int max = 1;
		List<Integer> maxList = new ArrayList<Integer>();
		maxList.add(arr[0]);
		List<List<Integer>> container = new ArrayList<List<Integer>>();
		
		for(int i = 0; i< arr.length; i++) {
			List<List<Integer>> tempContainer = new ArrayList<List<Integer>>();
			List<Integer> tempList = null;
			for(List<Integer> list : container) {
				if(null != list && list.size() > 0 && list.get(list.size() - 1) < arr[i]) {
					tempList = new ArrayList<Integer>();
					tempList.addAll(list);
					tempList.add(arr[i]);
					if(tempList.size() > max || 
							(tempList.size() == max && tempList.get(max - 1) < maxList.get(max - 1))) {
						maxList = tempList;
						max = tempList.size();
					}
					tempContainer.add(tempList);
				}
			}
			tempList = new ArrayList<Integer>(1);
			tempList.add(arr[i]);
			tempContainer.add(tempList);
			container.addAll(tempContainer);
		}
		
		return maxList;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestIncreasingSequence lis = new LongestIncreasingSequence();
		int[] source = {10, 22, 9, 33, 21, 50, 41, 60, 55, 56 };
		List<Integer> list = lis.longestSequence(source);
		System.out.println(list);
	}

}
