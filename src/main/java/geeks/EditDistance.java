package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 *
 */

public class EditDistance {

  public static void main (String[] args) {
    //code
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while(tc-- > 0) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      String s1 = sc.next();
      String s2 = sc.next();
      int[][] che = new int[m][n];
      //  System.out.println(distance(s1, s2, m - 1, n - 1));
      System.out.println(distanceDP(s1, s2, m - 1, n - 1, che));
    }
  }

  private static int distanceDP(String s1, String s2, int m, int n, int[][] che) {
    if (m < 0) {
      return n + 1;
    }
    if (n < 0) {
      return m + 1;
    }
    if (che[m][n] > 0) {
      return che[m][n];
    }
    int dis = Math.min(distanceDP(s1, s2, m - 1, n, che),
        Math.min(distanceDP(s1, s2, m, n - 1, che),
            distanceDP(s1, s2, m - 1, n - 1, che)));
    if (s1.charAt(m) != s2.charAt(n)) {
//      System.out.println(m + " " + n);
      dis += 1;
    }
	    /*if (s1.charAt(m) == s2.charAt(n)) {
	        dis = distanceDP(s1, s2, m - 1, n - 1, che);
	    } else {
	        dis = 1 + Math.min(distanceDP(s1, s2, m - 1, n, che),
    	        Math.min(distanceDP(s1, s2, m, n - 1, che),
    	        distanceDP(s1, s2, m - 1, n - 1, che)));
	    }*/
    che[m][n] = dis;
    return dis;
  }

  private static int distance(String s1, String s2, int m, int n) {
    if (m < 0 && n < 0) {
      return 0;
    }
    if (m < 0 || n < 0) {
      return 1;
    }
    if (s1.charAt(m) == s2.charAt(n)) {
      return distance(s1, s2, m - 1, n - 1);
    }
    return 1 + Math.min(distance(s1, s2, m - 1, n), distance(s1, s2, m, n - 1));
  }
}
