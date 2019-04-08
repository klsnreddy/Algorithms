package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parentheses {

  public static List<String> balancedParentheses(int k) {
    List<String> result = new ArrayList<>();
    char[] chars = new char[2 * k];
    parentheses(0, 0, k, chars, result);
    return result;
  }

  private static void parentheses(int l, int r, int k, char[] chars, List<String> result) {
    if(l == k && r == k) {
      result.add(new String(Arrays.copyOf(chars, 2 * k)));
      return;
    }

    if (l < k) {
      chars[l + r] = '(';
      parentheses(l + 1, r, k, chars, result);
    }

    if (r < l) {
      chars[l + r] = ')';
      parentheses(l, r + 1, k, chars, result);
    }
  }

}
