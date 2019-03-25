package leet;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

  public boolean isValid(String s) {
    if (null == s || s.length() <= 0) {
      return true;
    }
    if (s.length() == 1) {
      return false;
    }
    Deque<Character> stack = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack.offer(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char chr = stack.pop();
        if ((c == ')' && chr == '(') ||
            (c == ']' && chr == '[') ||
            (c == '}' && chr == '{')) {
          continue;
        }
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    ValidParentheses vp = new ValidParentheses();
    System.out.println(vp.isValid("([)]"));
  }
}
