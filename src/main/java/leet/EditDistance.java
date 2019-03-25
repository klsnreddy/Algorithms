package leet;

/**
 *
 */

public class EditDistance {

  public int minDistance(String word1, String word2) {
//    return minDistanceHelper(word1, word1.length() - 1, word2, word2.length() - 1, new int[word1.length()][word2.length()]);
    return distanceDP(word1, word2, word1.length() - 1,word2.length() - 1, new int[word1.length()][word2.length()]);
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
    /*int dis = Math.min(distanceDP(s1, s2, m - 1, n, che),
        Math.min(distanceDP(s1, s2, m, n - 1, che),
            distanceDP(s1, s2, m - 1, n - 1, che)));
    if (s1.charAt(m) != s2.charAt(n)) {
//      System.out.println(m + " " + n);
      if (m == 56 && n == 43)
        System.out.println(m + " " + n + " " + dis);
      dis += 1;

    }*/
    int dis = 0;
    if (s1.charAt(m) == s2.charAt(n)) {
        dis = distanceDP(s1, s2, m - 1, n - 1, che);
    } else {
        dis = 1 + Math.min(distanceDP(s1, s2, m - 1, n, che),
            Math.min(distanceDP(s1, s2, m, n - 1, che),
            distanceDP(s1, s2, m - 1, n - 1, che)));
    }
    che[m][n] = dis;
    return dis;
  }

  private int minDistanceHelper(String word1, int idx1, String word2, int idx2, int[][] cache) {

    if (idx1 < 0)
      return idx2 + 1;
    if (idx2 < 0)
      return idx1 + 1;

    if (cache[idx1][idx2] == 0) {
      int count = 0;
      if (word1.charAt(idx1) == word2.charAt(idx2)) {
        return minDistanceHelper(word1, idx1 - 1, word2, idx2 - 1, cache);
      } else {
        int word1Count = minDistanceHelper(word1, idx1, word2, idx2 - 1, cache);
        int word2Count = minDistanceHelper(word1, idx1 - 1, word2, idx2, cache);
        int bothCount = minDistanceHelper(word1, idx1 - 1, word2, idx2 - 1, cache);
        count = 1 + Math.min(bothCount, Math.min(word1Count, word2Count));
      }
      cache[idx1][idx2] = count;
    }
    return cache[idx1][idx2];
  }

  public static void main(String[] args) {
    EditDistance ed = new EditDistance();
    System.out.println(ed.minDistance("zvfrkmlnozjkpqpxrjxkitzyxacbhhkicqcoendtomfgdwdwfcgpxiqvk",
        "uytdlcgdewhtaciohordtqkvwcsgspqoqmsboaguwnny"));
  }
}
