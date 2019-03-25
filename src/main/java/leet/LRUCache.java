package leet;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache {

  public static void main(String[] args) {
    LinkedHashMap<String, String> map = new LinkedHashMap<>(5, 0.75f, true);
    map.put("one", "one");
    map.put("two", "two");
    map.put("three", "three");
    map.put("four", "four");
    map.put("five", "five");

    for (Entry<String, String> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    map.get("four");
    System.out.println("--------------");
    for (Entry<String, String> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
