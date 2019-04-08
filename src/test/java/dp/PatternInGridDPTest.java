package dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatternInGridDPTest {

  @Test
  public void isPatternInGrid() {
    int[][] grid = new int[][] {
        {1, 2, 3},
        {3, 4, 5},
        {5, 6, 7}
    };
    int[] inPattern = new int[]{1, 3, 4, 6};
    int[] outPattern = new int[]{1, 2, 3, 4};

    assertTrue("<1, 3, 4, 6> is in grid", PatternInGridDP.isPatternInGrid(grid, inPattern));
    assertFalse("<1, 2, 3, 4> is not in grid", PatternInGridDP.isPatternInGrid(grid, outPattern));
  }
}