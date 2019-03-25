package one;

import java.util.Arrays;

/**
 * Created by kreddy on 5/10/18.
 */
public class ArrayTest {

  public static void main(String[] args) {
    char[] one = "one".toCharArray();
    char[] two = "two".toCharArray();
    char[] three = "two".toCharArray();

    System.out.println(one);
    System.out.println(two);
    System.out.println(three);

    System.out.println(one.equals(two));
    System.out.println(three.equals(two));
    System.out.println(Arrays.equals(three, two));
  }
}
