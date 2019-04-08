package dp;

public class Fibonachi {

  public static int fibonachi(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;

    int fminus2 = 0;
    int fminus1 = 1;

    for (int i = 2; i <= n; i++) {
      int f = fminus1 + fminus2;
      fminus2 = fminus1;
      fminus1 = f;
    }
    return fminus1;
  }

}
