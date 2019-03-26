package recursion;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class QueensArrangmentTest {

  @Test
  public void test4() {
    QueensArrangment qa = new QueensArrangment(4);
    List<List<Integer>> result = qa.getPositions();
    assertNotNull(result);
    assertNotEquals("Result should not be empty", 0, result.size());
    System.out.printf(result.toString());
  }

  private void printResult(List<List<Integer>> result) {
    System.out.println(result);
//    StringBuilder sb = new StringBuilder();
//    result.forEach(r -> {
//      sb.append("[")
//    });
  }
}