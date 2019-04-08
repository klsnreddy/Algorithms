package recursion;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class CombinationsTest {

  @Test
  public void test3() {
    List<Integer> list = Arrays.asList(1, 2, 3);
    List<List<Integer>> result = Combinations.getCombinations(list);
    assertNotEquals("Result should not be empty", 0, result.size());
    assertEquals("Result size should be 8", 8, result.size());
    assertTrue("Result should contain <1, 2>", result.contains(Arrays.asList(1, 2)));
  }

  @Test
  public void test4() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4);
    List<List<Integer>> result = Combinations.getCombinations(list);
    assertNotEquals("Result should not be empty", 0, result.size());
    assertEquals("Result size should be 16", 16, result.size());
    assertTrue("Result should contain <1, 2>", result.contains(Arrays.asList(1, 2)));
  }
}