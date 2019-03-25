package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by kreddy on 2/13/18.
 */
public class RearrangeString {

  public static void main (String[] args) {
    //code
    Scanner sc = new Scanner(System.in);
    int numTestCases = sc.nextInt();
    for (int i = 0; i < numTestCases; i++) {
      System.out.println(getRearrangedString(sc.next()));
    }
  }

  private static String getRearrangedString(String src) {
    int[] chars = new int[26];
    int numChars = 0, sum = 0;
    for (int i = 0; i < src.length(); i++) {
      char c = src.charAt(i);
      if (c >= 'A' && c <= 'Z') {
        chars[c - 'A']++;
        numChars++;
      } else {
        sum += (c - '0');
      }
    }
    String numS = String.valueOf(sum);
    char[] chs = new char[numChars + numS.length()];
    int idx = 0;
    for (int i = 0; i < chars.length; i++) {
//      System.out.print(chars[i] + " ");
      while (chars[i]-- > 0) {
        chs[idx++] = (char ) ('A' + i);
      }
    }
    for (int i = 0; i < numS.length(); i++) {
      chs[idx++] = numS.charAt(i);
    }
    return String.valueOf(chs);
  }

}
