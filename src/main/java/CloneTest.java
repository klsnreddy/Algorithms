import java.util.ArrayList;
import java.util.List;


public class CloneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		l.add("one");
		l.add("two");
		List<String> l1 = (List<String>)l.clone();
		System.out.println(l1 == l);
		System.out.println(l1.equals(l));
		l1.add("three");
		System.out.println(l1.equals(l));
	}

}
