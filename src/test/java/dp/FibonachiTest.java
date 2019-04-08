package dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonachiTest {

  @Test
  public  void test1() {
    int result = Fibonachi.fibonachi(1);
    assertEquals("Result should be 1", 1, result);
  }

  @Test
  public  void test3() {
    int result = Fibonachi.fibonachi(3);
    assertEquals("Result should be 2", 2, result);
  }

  @Test
  public  void test5() {
    int result = Fibonachi.fibonachi(5);
    assertEquals("Result should be 5", 5, result);
  }
}