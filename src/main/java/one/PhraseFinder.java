package one;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by kreddy on 5/13/18.
 */
public class PhraseFinder {


  public static List<String> getPhrase(String path, List<String> excludes) {
    List<String> result = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    Map<String, Integer> wordCounts = new HashMap<>();
    Integer ZERO = new Integer(0);
    try (FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr)) {
      String line = br.readLine();
      Integer count = null;
      while(line != null) {
        String[] words = line.split("[:\\s*\\-_.,;'\"<>{}()\\[\\]]");
        for (String word : words) {
          System.out.println(word);
          word = word.trim().toLowerCase();

          if (word.length() == 0 || excludes.contains(word)) {
//            System.out.println("Ignoring : " + word);
            continue;
          }
          Integer i = wordCounts.getOrDefault(word, ZERO);
          count = i + 1;
          wordCounts.put(word, count);
          if (count > max) {
            max = count;
          }
        }
        line = br.readLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (Entry<String, Integer> entry : wordCounts.entrySet()) {
      if (entry.getValue() == max) {
        result.add(entry.getKey());
      }
    }
//    System.out.println(max);
//    System.out.println(result);
    return result;
  }

  public static void main(String[] args) {
//    System.out.println(getPhrase("/Users/kreddy/omni/docs/hive.txt", Arrays.asList(new String[]{"a", "an", "the", "as"})));
//    System.out.println(getPhrase("/Users/kreddy/omni/docs/commands.txt", Arrays.asList(new String[]{"a", "an", "the", "as"})));
//    System.out.println(getPhrase("/Users/kreddy/omni/docs/docker.txt", Arrays.asList(new String[]{"a", "an", "the", "as"})));
//    System.out.println(getPhrase("/Users/kreddy/omni/docs/Ansible.txt", Arrays.asList(new String[]{"a", "an", "the", "as"})));
    System.out.println(getPhrase("/Users/kreddy/omni/docs/test.txt", Arrays.asList(new String[]{"a", "an", "the", "as"})));

//    String str = "GeeksforGeeks:A Computer Science Portal{test}";
//    String [] arrOfStr = str.split("[:\\s*\\-_.,;'\"<>{}()[]]");
//
//    for (String a : arrOfStr)
//      System.out.println(a);
  }
}
