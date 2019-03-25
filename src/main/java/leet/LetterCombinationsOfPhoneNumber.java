package leet;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (null == digits || digits.length() == 0) {
      return result;
    }
    char[] chars = new char[digits.length()];
    char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    letterCombinations(digits, chars, 0, map, result);
    return result;
  }

  private void letterCombinations(String digits, char[] chars, int idx, char[][] map, List<String> result) {
    if (idx == digits.length()) {
      result.add(new String(chars));
      return;
    }

    char[] alphabets = map[digits.charAt(idx) - '0'];
    for (char c : alphabets) {
      chars[idx] = c;
      letterCombinations(digits, chars, idx + 1, map, result);
    }
  }

  public static void main(String[] args) {
    LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
    for (String s : letterCombinationsOfPhoneNumber.letterCombinations("23")) {
      System.out.println(s);
    }
  }
}
