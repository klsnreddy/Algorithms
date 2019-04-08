package dp;

import java.util.Arrays;
import java.util.List;

public class KnapSackValueDP {

  private static int count = 0;
  public static int knapSackValue(List<Item> items, int weightLimit) {
    count = 0;
    int[][] cache = new int[items.size()][weightLimit + 1];
    for (int[] che : cache) {
      Arrays.fill(che, -1);
    }
    int result = knapSackValue(items, weightLimit, 0, cache);
    System.out.println(count);
    return result;
  }

  private static int knapSackValue(List<Item> items, int weightLimit, int idx, int[][] cache) {
    if (idx == items.size() || weightLimit <= 0)
      return 0;
    if (cache[idx][weightLimit] >= 0)
      return cache[idx][weightLimit];
    count++;
    int result = 0;
    int nextValue = knapSackValue(items, weightLimit, idx + 1, cache);
    if (weightLimit < items.get(idx).weight) {
      result = nextValue;
    } else {
      int thisValue = items.get(idx).value +
          knapSackValue(items, weightLimit - items.get(idx).weight, idx + 1, cache);
      result = Math.max(nextValue, thisValue);
    }
    cache[idx][weightLimit] = result;
    return result;
  }

  public static class Item {
    private int weight;
    private int value;

    public Item(int weight, int value) {
      this.weight = weight;
      this.value = value;
    }
  }
}
