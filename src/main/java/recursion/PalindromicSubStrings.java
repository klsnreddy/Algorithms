package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubStrings {

  public static List<List<String>> palindromicSubStrings(String src) {
    List<List<String>> result = new ArrayList<>();
    List<String> partialPalindromes = new ArrayList<>();
    palindromicSubStrings(0, src.length() - 1, src.toCharArray(),
        partialPalindromes, result);
    return result;
  }

  private static void palindromicSubStrings(int start, int end, char[] chars,
      List<String> partialPalindromes, List<List<String>> result) {
    if (start > end) {
      result.add(new ArrayList<>(partialPalindromes));
      return;
    }
    int temp = end;
    while(temp >= start) {
      if (isPalindrome(chars, start, temp)) {
        partialPalindromes.add(String.valueOf(chars, start, temp - start + 1));
        palindromicSubStrings(temp + 1, end, chars, partialPalindromes, result);
        partialPalindromes.remove(partialPalindromes.size() - 1);
      }
      temp--;
    }

  }

  private static boolean isPalindrome(char[] chars, int start, int end) {
    while(start <= end) {
      if (chars[start] != chars[end]) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
