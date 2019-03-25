package stack.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by kreddy on 1/12/18.
 */
public class LongestKStrings {

  public static List<String> topK(int k , Iterator<String> iter) {
    PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
      }
    });


    while (iter.hasNext()) {
      minHeap.add(iter.next());
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    return new ArrayList<String>(minHeap);
  }

  public static List<String> smallK(int k , Iterator<String> iter) {
    PriorityQueue<String> maxHeap = new PriorityQueue<>(k, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Integer.compare(o2.length(), o1.length());
      }
    });


    while (iter.hasNext()) {
      maxHeap.add(iter.next());
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    return new ArrayList<String>(maxHeap);
  }

  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();

    list.add("one");
    list.add("three");
    list.add("Kallam");
    list.add("Kalpana");
    list.add("Reddy");
    list.add("Neptune");

    List<String> list1 = topK(3, list.iterator());
    System.out.println(list1);

    List<String> list2 = smallK(3, list.iterator());
    System.out.println(list2);
  }

}
