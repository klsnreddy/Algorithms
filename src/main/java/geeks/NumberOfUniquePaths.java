package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by kreddy on 2/20/18.
 */
public class NumberOfUniquePaths {

  public static void main (String[] args) {
    //code
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int r = sc.nextInt();
      int c = sc.nextInt();
      System.out.println(findWays(r, c));
    }
  }

  private static int findWays(int r, int c) {
    if (r == 0 || c == 0)
      return 0;
    int[][] che = new int[r][c];
    for (int i = 0; i < r; i++) {
      che[i][0] = 1;
    }
    for (int i = 0; i < c; i++) {
      che[0][i] = 1;
    }
    return findWays(r - 1, c - 1, che);
    // return che[r - 1][c - 1];
  }

  private static int findWays(int r, int c, int[][] che) {
    if (r < 0 || c < 0) {
      return 0;
    }
    if (che[r][c] > 0) {
      return che[r][c];
    }
    che[r][c] = findWays(r - 1, c, che) + findWays(r, c - 1, che);
    return che[r][c];
  }
}
