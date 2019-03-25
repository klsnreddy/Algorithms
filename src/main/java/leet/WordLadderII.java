package leet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kreddy on 5/12/18.
 */
public class WordLadderII {

  public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    // hash set for both ends
    Set<String> set1 = new HashSet<String>();
    Set<String> set2 = new HashSet<String>();

    // initial words in both ends
    set1.add(start);
    set2.add(end);

    // we use a map to help construct the final result
    Map<String, List<String>> map = new HashMap<String, List<String>>();

    // build the map
    helper(dict, set1, set2, map, false);

    List<List<String>> res = new ArrayList<List<String>>();
    List<String> sol = new ArrayList<String>(Arrays.asList(start));

    // recursively build the final result
    generateList(start, end, map, sol, res);

    return res;
  }

  boolean helper(Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
    if (set1.isEmpty()) {
      return false;
    }

    if (set1.size() > set2.size()) {
      return helper(dict, set2, set1, map, !flip);
    }

    // remove words on current both ends from the dict
    dict.removeAll(set1);
    dict.removeAll(set2);

    // as we only need the shortest paths
    // we use a boolean value help early termination
    boolean done = false;

    // set for the next level
    Set<String> set = new HashSet<String>();

    // for each string in end 1
    for (String str : set1) {
      for (int i = 0; i < str.length(); i++) {
        char[] chars = str.toCharArray();

        // change one character for every position
        for (char ch = 'a'; ch <= 'z'; ch++) {
          chars[i] = ch;

          String word = new String(chars);

          // make sure we construct the tree in the correct direction
          String key = flip ? word : str;
          String val = flip ? str : word;

          List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();

          if (set2.contains(word)) {
            done = true;

            list.add(val);
            map.put(key, list);
          }

          if (!done && dict.contains(word)) {
            set.add(word);

            list.add(val);
            map.put(key, list);
          }
        }
      }
    }

    // early terminate if done is true
    return done || helper(dict, set2, set, map, !flip);
  }

  void generateList(String start, String end, Map<String, List<String>> map, List<String> sol, List<List<String>> res) {
    if (start.equals(end)) {
      res.add(new ArrayList<String>(sol));
      return;
    }

    // need this check in case the diff between start and end happens to be one
    // e.g "a", "c", {"a", "b", "c"}
    if (!map.containsKey(start)) {
      return;
    }

    for (String word : map.get(start)) {
      sol.add(word);
      generateList(word, end, map, sol, res);
      sol.remove(sol.size() - 1);
    }
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    Set<String> set = new HashSet<>(wordList);
    Map<String, Set<String>> visited = new HashMap<>();
    Deque<String> queue = new ArrayDeque<>();
    queue.offer(beginWord);
    Set<String> pres = visited.computeIfAbsent(beginWord, w -> new HashSet<String>());
    pres.add(beginWord);
    getDist(queue, endWord, visited, set, result);
    return result;
  }

  private void getDist(Deque<String> queue, String dest, Map<String, Set<String>> visited, Set<String> dict, List<List<String>> result) {
    Deque<String> temp = new ArrayDeque<>();
    boolean found = false;
    while(!queue.isEmpty()) {
      String word = queue.removeFirst();
      List<String> words = getAdjacentWords(word, visited, dict);
//      System.out.println(words);
      for(String aWord : words) {
        Set<String> pres = visited.computeIfAbsent(aWord, w -> new HashSet<String>());
        pres.add(word);
        if (dest.equals(aWord)) {
          result.add(buildSequence(visited, dest));
          found = true;
        } else {
          temp.offer(aWord);
        }
      }
    }

    if (!found) {
      getDist(temp, dest, visited, dict, result);
    }
//    System.out.println(queue.size());
  }

  private List<String> buildSequence(Map<String, Set<String>> visited, String dest) {
    List<String> stack = new LinkedList<>();
    stack.add(dest);
    System.out.println(visited);
//    String pre = visited.get(dest);
//    while(pre != null && !dest.equals(pre)) {
//      dest = pre;
//      stack.add(0, dest);
//      pre = visited.get(dest);
//    }
    return stack;
  }

  private List<String> getAdjacentWords(String word, Map<String, Set<String>> visited, Set<String> dict) {
    List<String> list = new ArrayList<>();

    String aWord = null;
    for (int i = 0; i < word.length(); i++) {
      char[] chars = word.toCharArray();
      for (char c = 'a'; c <= 'z'; c++) {
        chars[i] = c;
        aWord = String.valueOf(chars);
        if (!dict.contains(aWord) || word.equals(aWord)) {
          continue;
        }
        list.add(aWord);
      }
    }
    return list;
  }

  public static void main(String[] args) {

    WordLadderII wl = new WordLadderII();
//    System.out.println(wl.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
    System.out.println(wl.findLadders("hit", "cog", new HashSet<>(Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}))));
  }
}
