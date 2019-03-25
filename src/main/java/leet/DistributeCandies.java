package leet;

import java.util.Arrays;

/**
 * Created by kreddy on 5/4/18.
 */
public class DistributeCandies {

  public static int distributeCandies(int[] candies) {
    if (null == candies || candies.length == 0) {
      return 0;
    }
    int[] distinct = Arrays.stream(candies).distinct().toArray();
    if (distinct.length > candies.length/2) {
      return candies.length/2;
    }
    return distinct.length;
  }

  public static void main(String[] args) {
    System.out.println(distributeCandies(new int[]{1,2,3,4}));
    System.out.println(distributeCandies(new int[]{1,1,3,4}));
    System.out.println(distributeCandies(new int[]{1,1,2,2}));
    System.out.println(distributeCandies(new int[]{1,1,2,1}));
    System.out.println(distributeCandies(new int[]{1,1,1,1}));
  }
}
