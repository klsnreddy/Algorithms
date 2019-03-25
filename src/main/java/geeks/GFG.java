package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

/**
 * Created by kreddy on 2/13/18.
 */

class GFG {
  public static void main (String[] args) {
    int[] nums = new int[]{46, 538, 782, -176, 681, 828, 282, 378, -227, 802, 801, -774, 368, 261};
    int sum = 0;
    for (int n : nums)
      sum += n;
    System.out.println(sum);
  }

  private static int maxResUsingAddOrProd(String exp) {
    int n = exp.length();
    int ldigit = exp.charAt(0)-'0', rdigit;
    int res = ldigit;
    for(int i = 1; i < n; i++) {
      rdigit = exp.charAt(i) - '0';
      if(ldigit == 0 || ldigit == 1 || rdigit == 0 || rdigit == 1) {
        res += rdigit;
      } else {
        res *= rdigit;
      }
      ldigit = rdigit;
    }
    return res;
  }

  private static void swap(int[] arr, int x, int y) {
    int _x = arr[x];
    arr[x] = arr[y];
    arr[y] = _x;
  }

  private static void print(int[] arr, int n) {
    String ans = Arrays.stream(arr).mapToObj(String::valueOf)
        .collect(java.util.stream.Collectors.joining(" "));
    System.out.print(ans);
  }
}
