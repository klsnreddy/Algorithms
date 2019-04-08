package dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class LevenshteinDistanceDPTest {

  @Test
  public void test_1() {
    assertEquals("Distance should be 1", 1,
        LevenshteinDistanceDP.levenshteinDistance("one", "ones"));
    assertEquals("Distance should be 1", 1,
        LevenshteinDistanceDP.levenshteinDistance("none", "nine"));
  }

  @Test
  public void test_2() {
    assertEquals("Distance should be 2", 2,
        LevenshteinDistanceDP.levenshteinDistance("eight", "eouht"));
  }
}