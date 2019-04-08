package dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class LevenshteinDistanceTest {

  @Test
  public void test_1() {
    assertEquals("Distance should be 1", 1,
        LevenshteinDistance.levenshteinDistance("one", "ones"));
    assertEquals("Distance should be 1", 1,
        LevenshteinDistance.levenshteinDistance("none", "nine"));
  }

  @Test
  public void test_2() {
    assertEquals("Distance should be 2", 4,
        LevenshteinDistance.levenshteinDistance("eight", "eouht"));
  }
}