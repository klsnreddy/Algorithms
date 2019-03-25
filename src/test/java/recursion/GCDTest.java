package recursion;

import static org.junit.Assert.*;

import com.sun.tools.javac.util.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GCDTest {

  private GCD g = new GCD();

  @Test
  public void test12() {
    assertEquals(g.gcd(12, 36), 12);
  }

  @Test
  public void test5() {
    assertEquals(g.gcd(15, 25), 5);
  }
}