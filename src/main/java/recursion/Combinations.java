package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations {

  public static List<List<Integer>>  getCombinations(List<Integer> src) {
    List<List<Integer>> result = new ArrayList<>();
    combinations(0, src, new ArrayList<>() , result);
    return result;
  }

  private static void combinations(int idx, List<Integer> src,
      List<Integer> list, List<List<Integer>> result) {
    if (idx == src.size()) {
      result.add(new ArrayList<>(list));
      return;
    }

    list.add(src.get(idx));
    combinations(idx + 1, src, list, result);
    list.remove(list.size() - 1);
    combinations(idx + 1, src, list, result);
  }

}
