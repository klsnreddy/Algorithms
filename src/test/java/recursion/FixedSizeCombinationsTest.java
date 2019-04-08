package recursion;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class FixedSizeCombinationsTest {

  @Test
  public void test3_2() {
    List<List<Integer>> result = FixedSizeCombinations.getCombinations(3, 2);
    assertNotEquals("Result should not be empty", 0, result.size());
    assertEquals("Result size should be 3", 3, result.size());
    assertTrue("Result should contain <1, 2>", result.contains(Arrays.asList(1, 2)));
    System.out.println(result);
  }

  @Test
  public void test4_2() {
    List<List<Integer>> result = FixedSizeCombinations.getCombinations(4, 2);
    assertNotEquals("Result should not be empty", 0, result.size());
    assertEquals("Result size should be 6", 6, result.size());
    assertTrue("Result should contain <2, 4>", result.contains(Arrays.asList(2, 4)));
    System.out.println(result);
  }
}