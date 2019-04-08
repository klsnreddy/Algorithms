package dp;

import java.util.List;

public class CombinationScores {

  public static int noOfWays(List<Integer> possiblePlays, int finalScore) {
    int result = 0;
    if (possiblePlays == null || possiblePlays.isEmpty())
      return result;

    int[][] cache = new int[possiblePlays.size() + 1][finalScore + 1];

    for (int i = 1; i < cache.length; i++) {
      cache[i][0] = 1;
      for (int j = 1; j < cache[0].length; j++) {
        int previous = (j - possiblePlays.get(i - 1)) < 0 ?
            0 : cache[i][j - possiblePlays.get(i - 1)];
        cache[i][j] = cache[i - 1][j] + previous;
      }
    }

    return cache[possiblePlays.size()][finalScore];
  }
}
