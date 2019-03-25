package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by kreddy on 2/20/18.
 */
public class NumberOfUniquePathsOptimized {

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
    if (r > c) {
      int temp = r;
      r = c;
      c = temp;
    }
    int[] che = new int[r + 1];
    Arrays.fill(che, 1);
    che[0] = 0;

    while (--c > 0) {
      // System.out.println(c);
      for (int i = 1; i <= r; i++) {
        che[i] += che[i - 1];
      }
      // Arrays.stream(che).forEach(j -> System.out.print(j + " "));
    }
    return che[r];
  }
}
