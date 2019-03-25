package leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsDups {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    if (nums == null || nums.length == 0) {
      return result;
    }

    Set<List<Integer>> set = new HashSet<>();

    List<Integer> list = new ArrayList<>();
    boolean[] cache = new boolean[nums.length];

    permute(nums, list, cache, set);

    set.stream().forEach(result::add);
    return result;
  }

  private void permute(int[] nums, List<Integer> list, boolean[] cache, Set<List<Integer>> result) {
    if (list.size() == nums.length) {
      result.add(new ArrayList<Integer>(list));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!cache[i]) {
        list.add(nums[i]);
        cache[i] = true;
        permute(nums, list, cache, result);
        cache[i] = false;
        list.remove(list.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    int[] input = {1,2,1};
    PermutationsDups perm = new PermutationsDups();
    List<List<Integer>> result = perm.permute(input);
    result.forEach(r -> {
      System.out.print("[");
      r.forEach(e -> System.out.print(e + ","));
      System.out.println("]");
    });
  }
}
