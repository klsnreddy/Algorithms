package geeks;

/**
 * Print Bracket Number
 Given an expression exp of length n consisting of some brackets. The task is to print the bracket numbers when the expression is being parsed.

 Input : (a+(b*c))+(d/e)
 Output : 1 2 2 1 3 3

 Input : ((())(()))
 Output : 1 2 3 3 2 4 5 5 4 1
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

/**
 * Created by kreddy on 4/8/18.
 */
public class PrintBracketNumber {

  public static String bracketNumber(String src) {
//    StringBuilder sb = new StringBuilder();

    StringJoiner sj = new StringJoiner(" ");
    Deque<Character> stack = new ArrayDeque<>();

    for (Character c: src.toCharArray()
    ) {
      if (c == '(') {
        stack.push(c);
        sj.add(String.valueOf(stack.size()));
      }
      if (c == ')') {
        sj.add(String.valueOf(stack.size()));
        stack.pop();
      }
    }

    return sj.toString();
  }

  public static void main(String[] args) {
    System.out.println(bracketNumber("(a+(b*c))+(d/e)"));
    assert "1 2 2 1 3 3".equals(bracketNumber("(a+(b*c))+(d/e)"));
    assert "1 2 3 3 2 4 5 5 4 1".equals(bracketNumber("((())(()))"));
  }
}
