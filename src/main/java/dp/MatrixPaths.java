package dp;

public class MatrixPaths {

  private static int count = 0;

  public static int noOfWays(int m, int n) {
    int result = 0;
    count = 0;
    if(m == 1 && n == 1)
      return 1;

    int[][] cache = new int[m+1][n+1];
    cache[1][1] = 1;
    result = noOfWays(m, n, cache);
    System.out.println("Count is : " + count);
    return result;
  }

  private static int noOfWays(int m, int n, int[][] cache) {
    if (m == 0 || n == 0)
      return 0;
    if (cache[m][n] > 0)
      return cache[m][n];

    count++;

    cache[m][n] = noOfWays(m - 1, n, cache) + noOfWays(m, n - 1, cache);
    return  cache[m][n];
  }
}
