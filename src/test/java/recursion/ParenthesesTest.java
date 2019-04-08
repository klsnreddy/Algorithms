package recursion;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ParenthesesTest {


  @Test
  public void test2() {
    List<String> result = Parentheses.balancedParentheses(2);
    assertNotEquals("Result should not be empty", 0, result.size());
    assertEquals("Result should have 2 strings", 2, result.size());
    assertTrue("Result should contain ()()", result.contains("()()"));
  }

  @Test
  public void test3() {
    List<String> result = Parentheses.balancedParentheses(3);
    assertNotEquals("Result should not be empty", 0, result.size());
    assertEquals("Result should have 5 strings", 5, result.size());
    assertTrue("Result should contain ()()()", result.contains("()()()"));
    assertTrue("Result should contain ()(())", result.contains("()(())"));
  }
}