package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by kreddy on 2/14/18.
 */
public class MaxSumWithAtLeastKElements {

  public static void main (String[] args) {
    //code
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while(tc-- > 0) {
      int[] input = new int[sc.nextInt()];
      for (int i = 0; i < input.length; i++) {
        input[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(getMaxSumAtLeastK(input, k));
    }
  }

  private static int getMaxSumAtLeastK(int[] input, int k) {
    if (input.length < k) {
      return -1;
    }

    int[] sums = new int[input.length];
    sums[0] = input[0];
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < input.length; i++) {
      sums[i] = sums[i - 1] + input[i];
    }
    Arrays.stream(sums).forEach(i -> System.out.print(i + " "));
    System.out.println("");

    for (int i = k - 1; i < input.length; i++) {
      max = Math.max(max, sums[i]);
      for (int lo = 0; lo <= i - k; lo++) {
        max = Math.max(max, sums[i] - sums[lo]);
      }
    }
    return max;
  }

  /*private static int getMaxSumAtLeastK(int[] input, int k) {
    if (input.length < k) {
      return -1;
    }
    int si = 0, ei = 0, sum = 0, maxSum = Integer.MIN_VALUE;
    while (ei < input.length) {
      if (ei - si < k) {
        sum += input[ei++];
      } else {
        maxSum = Math.max(maxSum, sum);
        sum += input[ei++];
        int pSum = 0;
        for (int i = si; i < ei - k; i++) {
          pSum += input[i];
          if (sum - pSum > maxSum) {
            maxSum = sum - pSum;
            si = i + 1;
          }
        }
        maxSum = Math.max(maxSum, sum);
      }
    }
    System.out.println(si);
    System.out.println(ei);
    return maxSum;
  }*/

}
