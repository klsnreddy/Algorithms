package dp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import recursion.Combinations;

public class CombinationScoresTest {

  @Test
  public void test3_12() {
    int result = CombinationScores.noOfWays(Arrays.asList(2,3,7), 12);
    assertEquals("Result should be 4", 4, result);
  }
}