package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public static List<List<Integer>>  getPermutations(List<Integer> list) {
    List<List<Integer>> result = new ArrayList<>();
    permutations(0, list, result);
    return result;
  }

  private static void permutations(int idx, List<Integer> list, List<List<Integer>> result) {

    if (idx == list.size() - 1) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = idx; i < list.size(); i++) {
      swap(list, i, idx);
      permutations(idx + 1, list, result);
      swap(list, i, idx);
    }
  }

  private static void swap(List<Integer> list, int i, int idx) {
    Integer temp = list.get(i);
    list.set(i, list.get(idx));
    list.set(idx, temp);
  }


}
