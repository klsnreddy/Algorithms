package recursion;

import java.util.Deque;
import java.util.LinkedList;

public class TowersOfHanoi {

  private final int numRings;

  private Deque<Integer> src = new LinkedList<>(),
                        dest = new LinkedList<>(),
                        temp = new LinkedList<>();

  public TowersOfHanoi(int numRings) {
    if (numRings <= 0) {
      throw new IllegalArgumentException("Number of rings should be greater than zero");
    }
    this.numRings = numRings;

    for (int i = numRings; i >= 1; i--) {
      src.addFirst(i);
    }
  }

  public void performHanoi() {
    if (src.isEmpty()) {
      throw new IllegalStateException("Hanoi is already done");
    }
    doHanoi(numRings, src, dest, temp);
  }

  private void doHanoi(int numRings, Deque<Integer> src, Deque<Integer> dest, Deque<Integer> temp) {
    if (numRings <= 0)
      return;
    doHanoi(numRings - 1, src, temp, dest);
    dest.addFirst(src.removeFirst());
    doHanoi(numRings - 1, temp, dest, src);
  }



}
