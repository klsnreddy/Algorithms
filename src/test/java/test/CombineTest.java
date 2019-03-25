package test;

import static org.junit.Assert.*;

import com.sun.jnlp.JNLPClassLoaderUtil;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite.SuiteClasses;


//@RunWith(Parameterized.class)
public class CombineTest {

  public static interface AddTests { /* category marker */ }
  public static interface MulTests { /* category marker */ }
  public static interface SmokeTests { /* category marker */ }


  @RunWith(Parameterized.class)
  @Category(AddTests.class)
  public static class CombineAddTest {
    private int a;
    private int b;
    private int expected;

    public CombineAddTest(int a, int b, int expected) {
      this.a = a;
      this.b = b;
      this.expected = expected;
    }

    @Parameters
    public static Collection<Integer[]> data() {
      return Arrays.asList(new Integer[][]{
          {1,2,3},
          {4,6,10},
          {10,5,15}
      });
    }

    @Test
    public void add() {
      assertEquals(expected, Combine.add(a, b));
    }
  }


  @RunWith(Parameterized.class)
  @Category(MulTests.class)
  public static class CombineMulTest {
    private int a;
    private int b;
    private int expected;

    public CombineMulTest(int a, int b, int expected) {
      this.a = a;
      this.b = b;
      this.expected = expected;
    }

    @Parameters
    public static Collection<Integer[]> data() {
      return Arrays.asList(new Integer[][]{
          {1,2,2},
          {4,6,24},
          {10,5,50}
      });
    }

    @Test
    public void mul() {
      System.out.println("Muliti");
      assertEquals(expected, Combine.mul(a, b));
    }
  }


  @RunWith(Categories.class)
  @Categories.IncludeCategory(AddTests.class)
  @SuiteClasses(CombineAddTest.class)
  public static class AddSuite {

  }

  @RunWith(Categories.class)
  @Categories.IncludeCategory(MulTests.class)
  @SuiteClasses(CombineMulTest.class)
  public static class MulSuite {

  }


  @Test
  public void testCombine() {
    Result testResult = JUnitCore.runClasses(AddSuite.class, MulSuite.class);
    assertTrue(testResult.wasSuccessful());
  }
}