package leet;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kreddy on 4/26/18.
 */
public class WordBreak {

  public static boolean wordBreak(String s, List<String> wordDict) {
    boolean[] cache = new boolean[s.length()];
    boolean result = wordBreakBack(s, wordDict, 0, s.length(), cache);
    return result;
  }

  private static boolean wordBreakBack(String s, List<String> dict, int si, int ei, boolean[] cache) {
    if (cache[si]) {
      return false;
    }
    for (int i = ei; i > si; i--) {
      if (dict.contains(s.substring(si, i))) {
        if (i == ei) {
          return true;
        }
        if (wordBreak(s, dict, i, ei)) {
          return true;
        }
      }
    }
    cache[si] = true;
    return !cache[si];
  }

  private static boolean wordBreak(String s, List<String> dict, int si, int ei) {
    for (int i = si + 1; i <= ei; i++) {
      if (dict.contains(s.substring(si, i))) {
        if (i == ei) {
          return true;
        }
        if (wordBreak(s, dict, i, ei)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String s = "leetcode";
    List<String> wd = Arrays.asList("leet", "code");

//    String s = "applepenapple";
//    List<String> wd = Arrays.asList("apple", "pen");

//    String s = "catsandog";
//    List<String> wd = Arrays.asList("cats", "dog", "sand", "and", "cat");

    System.out.println(wordBreak(s, wd));
  }
}
