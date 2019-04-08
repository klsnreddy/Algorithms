package dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinomialCoefficientTest {

  @Test
  public void computeBinomialCoefficient() {
    assertEquals("(5 3) should be 10", 10,
        BinomialCoefficient.computeBinomialCoefficient(5, 3));
    assertEquals("(6 3) should be 20", 20,
        BinomialCoefficient.computeBinomialCoefficient(6, 3));
    assertEquals("(7 1) should be 7", 7,
        BinomialCoefficient.computeBinomialCoefficient(7, 1));
  }
}