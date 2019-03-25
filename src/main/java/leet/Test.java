package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by kreddy on 4/10/18.
 */
public class Test {

  public static void main(String[] args) {
//    List<int[]> list = new ArrayList<>();
//    list.add(new int[]{1,2});
//    list.add(new int[]{2,3});
//    list.add(new int[]{4,5});
//
//    list.forEach(e -> System.out.println(e[0] + ":" + e[1]));
//
//    List<int[]> list1 = Arrays.asList(new int[]{1,2}, new int[]{3,4});
//
//    list1.forEach(e -> System.out.println(e[0] + ":-" + e[1]));
//
//    System.out.println(1 + "1");
//
//    List<Integer> ints = new ArrayList<>(5);
//    ints.add(1);
//    ints.add(2);
//    ints.add(3);
//    ints.add(4);
//    ints.add(5);
//
//    System.out.println(ints.remove(2));
//    System.out.println(ints.remove(Integer.valueOf(2)));
//    System.out.println(ints.size() + ": " + ints);

    Map<Integer, List<Integer>> map = new HashMap<>();
    List<Integer> list = map.computeIfAbsent(1, x -> new ArrayList<>());
    list.add(1);
    System.out.println(map.get(1));

    Optional<Integer> i = Optional.of(null);

  }
}
