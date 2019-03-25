package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kreddy on 4/19/18.
 */
public class MaxWidthOfBinaryTree {

  int ans;
  Map<Integer, Integer> left;
  public int widthOfBinaryTree(TreeNode root) {
    ans = 0;
    left = new HashMap<>();
    dfs(root, 0, 0);
    return ans;
  }
  public void dfs(TreeNode root, int depth, int pos) {
    if (root == null) return;
    left.computeIfAbsent(depth, x-> pos);
    ans = Math.max(ans, pos - left.get(depth) + 1);
    dfs(root.left, depth + 1, 2 * pos);
    dfs(root.right, depth + 1, 2 * pos + 1);
  }

  public static void main(String[] args) {

  }
}

class AnnotatedNode {
  TreeNode node;
  int depth, pos;
  AnnotatedNode(TreeNode n, int d, int p) {
    node = n;
    depth = d;
    pos = p;
  }
}
