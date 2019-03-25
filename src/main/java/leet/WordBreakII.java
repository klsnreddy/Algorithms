package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kreddy on 4/27/18.
 */
public class WordBreakII {

  public static List<String> wordBreak(String s, List<String> wordDict) {
    //result a list to store the strings
    StringBuilder sb = new StringBuilder();
    Map<Integer, List<String>> cache = new HashMap<>();
    Boolean[] pos = new Boolean[s.length()];
    wordBreak(s, wordDict, 0, pos, cache, "");
    return cache.computeIfAbsent(s.length(), x -> new ArrayList<String>());
  }

  private static boolean wordBreak(String s, List<String> dict, int idx,
      Boolean[] pos, Map<Integer, List<String>> cache, String pre) {
    if (idx == s.length()) {
//      System.out.println("reached");
      List<String> list = cache.computeIfAbsent(idx, x -> new ArrayList<String>());
      list.add(pre.substring(0, pre.length() - 1));
      return true;
    }

    if (pos[idx] != null && !pos[idx]) {
      return false;
    }

    for (int i = idx + 1; i <= s.length(); i++) {
      if (dict.contains(s.substring(idx, i))) {
        if (wordBreak(s, dict, i, pos, cache, pre + s.substring(idx, i) + " ")) {
          pos[idx] = true;
        } else if (pos[idx] == null) {
          pos[idx] = false;
        }
      }
    }
    if (null == pos[idx]) {
      pos[idx] = false;
    }
    return pos[idx];
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
