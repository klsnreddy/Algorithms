package recursion;

import java.util.ArrayList;
import java.util.List;

public class FixedSizeCombinations {


  public static List<List<Integer>>  getCombinations(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    combinations(n, k, 1, new ArrayList<>() , result);
    return result;
  }

  private static void combinations(int n, int k, int offset, List<Integer> partialCombination,
      List<List<Integer>> result) {

    if (partialCombination.size() == k) {
      result.add(new ArrayList<>(partialCombination));
      return;
    }

    int numRemaining = k - partialCombination.size();

    for (int i = offset; i <= n && numRemaining <= n - i + 1; i++) {
      partialCombination.add(i);
      combinations(n, k, i + 1, partialCombination, result);
      partialCombination.remove(partialCombination.size() - 1);
    }
  }
}
