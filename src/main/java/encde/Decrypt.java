package encde;

/**
 * Created by kreddy on 2/5/18.
 */
public class Decrypt {

  public static String decrypt(String src) {
    if (null == src || src.length() == 0)
      return src;
    int[] encs = new int[src.length()];
    int counter = 0;
    for (int i = 0; i < encs.length; i++) {
      encs[i] = src.charAt(i);
      if (i != 0) {
        encs[i] += counter * 26;
        while(encs[i] - encs[i-1] < 97) {
          encs[i] += 26;
          counter++;
        }
      }
    }

    char[] decs = new char[encs.length];
    for (int i = encs.length - 1; i > 0; i--) {
      decs[i] = (char) (encs[i] - encs[i-1]);
    }
    decs[0] = (char) --encs[0];

    return String.valueOf(decs);
  }

  public static void main(String[] args) {
    System.out.println(decrypt("dnotq"));
    System.out.println(decrypt("flgxswdliefy"));
  }
}
