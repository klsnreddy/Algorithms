package dp;

public class BinomialCoefficient {

  public static int computeBinomialCoefficient(int n, int k) {
    return computeBionomialCoefficient(n, k, new int[n + 1][k + 1]);
  }

  private static int computeBionomialCoefficient(int n, int k, int[][] cache) {
    if (n == k || k == 0)
      return 1;
    if (cache[n][k] > 0)
      return cache[n][k];

    cache[n][k] = computeBionomialCoefficient(n - 1, k, cache) +
        computeBionomialCoefficient(n - 1, k - 1, cache);

    return cache[n][k];
  }
}
