package leet.tree;

import java.util.*;

/**
 * Created by kreddy on 7/26/19.
 */
public class UniqueBinarySearchTreesII {

  public List<TreeNode> generateTrees(int n) {
    List<TreeNode> result = new ArrayList();

    result = generateTrees(1, n);

    return result;
  }

  private List<TreeNode> generateTrees(int s, int e) {
    List<TreeNode> result = new ArrayList();
    if (s > e) {
      result.add(null);
      return result;
    }
    if (s == e) {
      TreeNode node = new TreeNode(s);
      result.add(node);
      return result;
    }
//    System.out.println("Got here");
    for (int i = s; i <= e; i++) {
      List<TreeNode> leftTrees = generateTrees(s, i - 1);
      List<TreeNode> rightTrees = generateTrees(i + 1, e);
      result.addAll(getTrees(i, leftTrees, rightTrees));
    }
    return result;
  }

  private List<TreeNode> getTrees(int val, List<TreeNode> leftTrees, List<TreeNode> rightTrees) {
//    System.out.println(val);
    List<TreeNode> result = new ArrayList();
    TreeNode node = null;
    for (TreeNode leftTree : leftTrees) {
      for (TreeNode rightTree : rightTrees) {
        node = new TreeNode(val);
        node.left = leftTree;
        node.right = rightTree;
        result.add(node);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    UniqueBinarySearchTreesII ubst = new UniqueBinarySearchTreesII();
    List<TreeNode> result = ubst.generateTrees(2);
    System.out.println(result.size());
  }
}
