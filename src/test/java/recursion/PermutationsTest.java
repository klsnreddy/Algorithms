package recursion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class PermutationsTest {

  @Test
  public void test3() {
    List<Integer> list = Arrays.asList(1, 2, 3);
    List<List<Integer>> result = Permutations.getPermutations(list);
    assertNotEquals("Result should not be empty", 0, result.size());
    assertEquals("Result size should be 6", 6, result.size());
    assertTrue("Result should contain <3,2,1>", result.contains(Arrays.asList(3, 2, 1)));
  }

  @Test
  public void test4() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4);
    List<List<Integer>> result = Permutations.getPermutations(list);
    assertNotEquals("Result should not be empty", 0, result.size());
    assertEquals("Result size should be 24", 24, result.size());
    assertTrue("Result should contain <3,2,1,4>", result.contains(Arrays.asList(3, 2, 1, 4)));
  }
}