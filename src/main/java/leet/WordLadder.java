package leet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kreddy on 5/12/18.
 */
public class WordLadder {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    Map<String, Integer> visited = new HashMap<>();
    Deque<String> queue = new ArrayDeque<>();
    queue.offer(beginWord);
    visited.put(beginWord, 1);
    return getDist(queue, endWord, visited, set);
  }

  private int getDist(Deque<String> queue, String dest, Map<String, Integer> visited, Set<String> dict) {
    while(!queue.isEmpty()) {
      String word = queue.removeFirst();
      List<String> words = getAdjacentWords(word, visited, dict);
      Integer dist = visited.get(word) + 1;
      for(String aWord : words) {
        if (dest.equals(aWord)) {
          return dist;
        }
        queue.offer(aWord);
        visited.put(aWord, dist);
      }
    }
    return 0;
  }

  private List<String> getAdjacentWords(String word, Map<String, Integer> visited, Set<String> dict) {
    List<String> list = new ArrayList<>();

    String aWord = null;
    for (int i = 0; i < word.length(); i++) {
      char[] chars = word.toCharArray();
      for (char c = 'a'; c <= 'z'; c++) {
        chars[i] = c;
        aWord = String.valueOf(chars);
        if (!dict.contains(aWord) || visited.containsKey(aWord)) {
          continue;
        }
        list.add(aWord);
      }
    }
    return list;
  }

  public static void main(String[] args) {

    WordLadder wl = new WordLadder();
    System.out.println(wl.ladderLength("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
  }
}
