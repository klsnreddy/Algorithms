package dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixPathsTest {

  @Test
  public void noOfWays() {
    assertEquals("5X5 result should be 70", 70, MatrixPaths.noOfWays(5, 5));
    assertEquals("5X4 result should be 35", 35, MatrixPaths.noOfWays(5, 4));
  }
}