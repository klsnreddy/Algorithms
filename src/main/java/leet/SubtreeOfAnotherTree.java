package leet;

/**
 * Created by kreddy on 5/4/18.
 */
public class SubtreeOfAnotherTree {

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }
    // System.out.println(s.val + ":" + t.val);
    if (s.val == t.val && exact(s.left, t.left) && exact(s.right, t.right)) {
      return true;
    }
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  private boolean exact(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null || s.val != t.val) {
      return false;
    }
    return exact(s.left, t.left) && exact(s.right, t.right);
  }

  public static void main(String[] args) {

  }
}
