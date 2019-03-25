package leet;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Created by kreddy on 5/8/18.
 */
public class MRU {

  public static void main(String[] args) {
    LinkedHashMap<String, String> lhm = new LinkedHashMap<>(4, 0.75f, true);
    lhm.put("one", "one");
    lhm.put("two", "two");
    lhm.put("three", "three");
    lhm.put("one", "four");
    lhm.get("three");

    for(Entry<String, String> e : lhm.entrySet()) {
      System.out.println(e.getKey() + ":" + e.getValue());
    }
  }
}
