package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by kreddy on 2/13/18.
 */
public class MaximumIntegerValue {

  private static int getIntValue(String s) {
    if (null == s || s.length() == 0) {
      return 0;
    }
    int previousNum = s.charAt(0) - '0';
    int num = previousNum;
    for (int i = 1; i < s.length(); i++) {
      int currentNum = s.charAt(i) - '0';
      if (previousNum == 0 ||
          previousNum == 1 ||
          currentNum == 0 ||
          currentNum == 1) {
        num += currentNum;
      } else {
        num *= currentNum;
      }
      previousNum = currentNum;
    }
    //System.out.println(num);
    return num;
  }

  private static void maxNum(String[] nums) {
    int max = Integer.MIN_VALUE;
    for (String s : nums) {
      //max = Math.max(max, getIntValue(s));
      System.out.println(getIntValue(s));
    }
    // return max;
  }

  public static void main (String[] args) {
    //code
    Scanner s = new Scanner(System.in);
    args = new String[s.nextInt()];
    for (int i = 0; i < args.length; i++) {
      args[i] = s.next();
    }
// 		args = list.toArray(new String[list.size()]);
// 		System.out.println(maxNum(args));
    maxNum(args);
  }
}
