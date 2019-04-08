package dp;

import java.util.List;

public class KnapSackValue {

  private static int count = 0;
  public static int knapSackValue(List<Item> items, int weightLimit) {
    count = 0;
    int result = knapSackValue(items, weightLimit, 0);
    System.out.println(count);
    return result;
  }

  private static int knapSackValue(List<Item> items, int weightLimit, int idx) {
    if (idx == items.size() || weightLimit <= 0)
      return 0;
    count++;
    int nextValue = knapSackValue(items, weightLimit, idx + 1);
    if (weightLimit < items.get(idx).weight) {
      return nextValue;
    }
    int thisValue = items.get(idx).value +
        knapSackValue(items, weightLimit - items.get(idx).weight, idx + 1);
    return Math.max(nextValue, thisValue);
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
