package leet;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {

  public List<String> removeInvalidParentheses(String s) {

    List<String> result = new ArrayList<>();
    if (null == s || s.length() == 0) {
      return result;
    }
    int lc = 0;
    int rc = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        lc++;
      } else if (c == ')') {
        rc++;
      }
    }

    return result;
  }

  public static void main(String[] args) {

  }
}
