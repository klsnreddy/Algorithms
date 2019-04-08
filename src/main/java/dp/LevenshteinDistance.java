package dp;

public class LevenshteinDistance {

  private static int count = 0;

  public static int levenshteinDistance(String src, String target) {
    count = 0;
    int result = levenshteinDistance(src, target, src.length() - 1, target.length() - 1);
    System.out.println("Count is " + count);
    return result;
  }

  private static int levenshteinDistance(String src, String target, int si, int ti) {
    if (si < 0)
      return ti + 1;
    if (ti < 0)
      return si + 1;

    count++;

    int previous = levenshteinDistance(src, target, si - 1, ti - 1);

    if (src.charAt(si) == target.charAt(ti)) {
      return previous;
    } else {
      return 1 + Math.min(previous, Math.min(levenshteinDistance(src, target, si - 1, ti),
          levenshteinDistance(src, target, si, ti - 1)));
    }
  }
}
