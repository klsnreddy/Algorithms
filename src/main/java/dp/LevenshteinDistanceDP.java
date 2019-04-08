package dp;

import java.util.Arrays;

public class LevenshteinDistanceDP {

  private static int count = 0;

  public static int levenshteinDistance(String src, String target) {
    count = 0;
    int[][] cache = new int[src.length()][target.length()];
    for (int i = 0; i < cache.length; i++) {
      Arrays.fill(cache[i], -1);
    }
    int result = levenshteinDistance(src, target, src.length() - 1, target.length() - 1, cache);
    System.out.println("Count is " + count);
    return result;
  }

  private static int levenshteinDistance(String src, String target, int si, int ti, int[][] cache) {
    if (si < 0)
      return ti + 1;
    if (ti < 0)
      return si + 1;

    if (cache[si][ti] >= 0)
      return cache[si][ti];

    count++;

    int result = levenshteinDistance(src, target, si - 1, ti - 1, cache);

    if (src.charAt(si) != target.charAt(ti)) {
      result = 1 + Math.min(result, Math.min(levenshteinDistance(src, target, si - 1, ti, cache),
          levenshteinDistance(src, target, si, ti - 1, cache)));
    }
    cache[si][ti] = result;
    return result;
  }
}
