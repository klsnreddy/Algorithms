package geeks;

import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

/**
 *
 */

public class CoinChange {

  public static void main (String[] args) {
    //code
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while(tc-- > 0) {
      int nc = sc.nextInt();
      int[] coins = new int[nc];
      for (int i = 0; i < nc; i++) {
        coins[i] = sc.nextInt();
      }
      Arrays.sort(coins);
      int n = sc.nextInt();

      System.out.println(noOfWays(n, coins));
    }
  }

  private static int noOfWays(int n, int[] coins) {
    int[] che = new int[n + 1];
    int min = 0;
    while (min < n) {
      if (min == 3) {
      }
      for (int i : coins) {
        if (min + i <= n) {
          if(che[min + i] <= che[min]) {
            che[min + i] = che[min] + 1;
          }
        } else {
          break;
        }
      }
      min += coins[0];
    }
    Arrays.stream(che).forEach(System.out::print);
    System.out.println("");
    return che[n];
  }
}
