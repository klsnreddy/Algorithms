package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by kreddy on 2/15/18.
 */
public class TotalDecodingMessages {

  public static void main (String[] args) {
    //code
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int len = sc.nextInt();
      if (len > 0) {
        String s = sc.next();
        if (validString(s)) {
          System.out.println(getWays(s, 0));
        } else {
          System.out.println(0);
        }
      }
    }
  }

  private static int getWays(String s, int idx) {
    if (idx == s.length()) {
      return 1;
    }
    if (idx > s.length()) {
      return 0;
    }
    if (idx + 1 < s.length() && s.charAt(idx + 1) == '0') {
      return getWays(s, idx + 2);
    }
    int result = 0;
    char c = s.charAt(idx);
    if (c == '1' || (idx + 1 < s.length() && c == '2' &&
        s.charAt(idx + 1) < '7')) {
      result += getWays(s, idx + 2);
    }
    result += getWays(s, idx + 1);
    return result;
  }

  private static boolean validString(String s) {
    if (s.charAt(0) == '0') {
      return false;
    }
    char pre = s.charAt(0);
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == '0' && !(pre == '1' || pre == '2')) {
        return false;
      }
      pre = s.charAt(i);
    }
    return true;
  }
}
