package tree;

/**
 * Created by kreddy on 1/8/18.
 */
public class BuildTreeFromPreInOrder {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (null != preorder && preorder.length > 0)
      return getRootNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
    else
      return null;
  }

  private TreeNode getRootNode(int[] preorder, int pmin, int pmax, int[] inorder, int imin, int imax) {
    if (imin > imax || pmin >= preorder.length)
      return null;
    int rIndex = getRootIndex(inorder, imin, imax, preorder[pmin]);
    TreeNode node = new TreeNode(inorder[rIndex]);
    node.left = getRootNode(preorder, pmin + 1, pmin + rIndex - imin, inorder, imin, rIndex - 1);
    node.right = getRootNode(preorder, pmin + rIndex - imin + 1, pmax, inorder, rIndex + 1, imax);
    return node;
  }

  private int getRootIndex(int[] inorder, int min, int max, int element) {
    for (int i = min; i <= max; i++) {
      if (inorder[i] == element)
        return i;
    }
    return 0;
  }

//  private int getRootIndex(int[] inorder, int min, int max, int element) {
//    int mid = (min + max) / 2;
//    if (inorder[mid] > element) {
//      return getRootIndex(inorder, min, mid - 1, element);
//    } else if (inorder[mid] < element) {
//      return getRootIndex(inorder, mid + 1, max, element);
//    } else {
//      return mid;
//    }
//  }

  public static void main(String[] args) {
    BuildTreeFromPreInOrder btfpi = new BuildTreeFromPreInOrder();
//    TreeNode node = btfpi.buildTree(new int[]{1,2,3}, new int[]{3,2,1});
    TreeNode node = btfpi.buildTree(new int[]{3,2,1}, new int[]{1,2,3});
    System.out.println(node);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}