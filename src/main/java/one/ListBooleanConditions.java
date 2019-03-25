package one;

import java.util.ArrayList;
import java.util.List;

public class ListBooleanConditions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> one = null;
		List<String> two = new ArrayList<String>();
		two.add("2");

		if(one != null && one.size() > 0 || two != null && two.size() > 1) {
			System.out.println("done");
		} else {
			System.out.println("Not done");
		}
	}

}
