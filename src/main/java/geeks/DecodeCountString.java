package geeks;

/**
 * An encoded string (s) is given, the task is to decode it. The pattern in which the strings are encoded is as follows.
 * <count>[sub_str] ==> The substring 'sub_str'
 appears count times.
 Input : str[] = "1[b]"
 Output : b

 Input : str[] = "2[ab]"
 Output : abab

 Input : str[] = "2[a2[b]]"
 Output : abbabb

 Input : str[] = "3[b2[ca]]"
 Output : bcacabcacabcaca
 */

/**
 * Created by kreddy on 4/8/18.
 */
public class DecodeCountString {


  public static String decode(String src) {

    StringBuilder sb = new StringBuilder();

    if (src != null && src.length() > 0) {
      int count = 0;
      int i = 0;
      String s = "";
      while(i < src.length()) {
        if (Character.isAlphabetic(src.charAt(i))) {
          sb.append(src.charAt(i));
        }

        if (Character.isDigit(src.charAt(i))) {
          count = count * 10 + (src.charAt(i) - '0');
        }

        if (src.charAt(i) == '[') {
          if(count == 0) {
            count = 1;
          }
          s = decode(src.substring(i + 1, src.length() - 1));
          break;
        }
        i++;
      }
//      System.out.println(src.length() + ":" + (i + 1) + ":" + (src.length() - 1));

      while(count > 0) {
        sb.append(s);
        count--;
      }

    }
    return sb.toString();
  }

  public static void main(String[] args) {
    assert("b".equals (decode("1[b]")));
    assert("abab".equals (decode("2[ab]")));
    assert("abbabb".equals (decode("2[a2[b]]")));
    assert("bcacabcacabcaca".equals (decode("3[b2[ca]]")));
  }
}
