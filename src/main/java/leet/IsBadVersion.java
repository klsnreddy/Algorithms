package leet;

public class IsBadVersion {


    public int firstBadVersion(int n) {
      if (n <= 0) {
        return 0;
      }
      int badVersion = Integer.MAX_VALUE;
      int s = 0;
      int e = n;
      int calls = 0;
      while (s <= e) {
        int m = (e + s) / 2;
        calls++;
        if (isBadVersion(m)) {
          badVersion = Math.min(badVersion, m);
          e = m - 1;
        } else {
          s = m + 1;
        }
      }
      System.out.println(calls);
      return badVersion;
    }

    private boolean isBadVersion(int n) {
      if (n >= 88) return true;
      return false;
    }

  public static void main(String[] args) {
    IsBadVersion ibv = new IsBadVersion();
    System.out.println(ibv.firstBadVersion(100));
  }
}
