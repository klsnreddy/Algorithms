package loops;

/**
 * Created by kreddy on 2/21/18.
 */
public class ForExitCondition {

  private static int limit() {
    System.out.println("Limit called");
    return 5;
  }
  public static void main(String[] args) {
    for (int i = 0; i < limit(); i++);
  }
}
