package leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

  public List<List<Integer>> subsets(int[] nums) {
    if (null == nums || nums.length == 0) {
      return null;
    }
    List<List<Integer>> result = subsets(nums, 0);
    return result;
  }

  private List<List<Integer>> subsets(int[] nums, int idx) {
    List<List<Integer>> result = new ArrayList<>();
    if (idx == nums.length) {
      result.add(new ArrayList<>());
      return result;
    }

    List<List<Integer>> sets = subsets(nums, idx + 1);
    result.addAll(sets);
    List<Integer> dest = null;
    for (List<Integer> set : sets) {
      dest = new ArrayList<>();
      Collections.copy(set, dest);
      dest.add(nums[idx]);
      result.add(dest);
    }

    return result;
  }

  public static void main(String[] args) {
    Subsets ss = new Subsets();

  }
}
