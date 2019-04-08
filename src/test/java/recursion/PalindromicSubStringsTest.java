package recursion;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class PalindromicSubStringsTest {

  @Test
  public void test3_1() {
    List<List<String>> result = PalindromicSubStrings.palindromicSubStrings("121");
    assertNotEquals("Result should not be empty", 0, result.size());
    assertEquals("Result size should be 1", 2, result.size());
    assertTrue("Result should contain <121>", result.contains(Arrays.asList("121")));
    assertTrue("Result should contain <1, 2, 1>",
        result.contains(Arrays.asList("1", "2", "1")));
    System.out.println(result);
  }

  @Test
  public void test3_2() {
    List<List<String>> result = PalindromicSubStrings.palindromicSubStrings("112");
    assertNotEquals("Result should not be empty", 0, result.size());
    assertEquals("Result size should be 2", 2, result.size());
    assertTrue("Result should contain <1, 1, 2>",
        result.contains(Arrays.asList("1", "1", "2")));
    assertTrue("Result should contain <11, 2>", result.contains(Arrays.asList("11", "2")));
    System.out.println(result);
  }

  @Test
  public void test10_12() {
    List<List<String>> result = PalindromicSubStrings.palindromicSubStrings("0204451881");
    assertNotEquals("Result should not be empty", 0, result.size());
    assertEquals("Result size should be 2", 12, result.size());
    assertTrue("Result should contain <020, 44, 5, 1881>",
        result.contains(Arrays.asList("020", "44", "5", "1881")));
    System.out.println(result);
  }

}