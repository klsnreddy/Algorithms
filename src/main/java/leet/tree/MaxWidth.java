package leet.tree;

import java.util.*;

/**
 * Created by kreddy on 7/26/19.
 */
public class MaxWidth {

  public int widthOfBinaryTree(TreeNode root) {
    Deque<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    return widthOfBinaryTree(queue, 0);
  }

  private int widthOfBinaryTree(Deque<TreeNode> queue, int max) {
    trimQueue(queue);
    if(queue.isEmpty())
      return max;
    if (queue.size() > max)
      max = queue.size();

    Deque<TreeNode> tempQueue = new LinkedList();
    while(!queue.isEmpty()) {
      TreeNode node = queue.removeFirst();
      if (node != null) {
        tempQueue.addLast(node.left);
        tempQueue.addLast(node.right);
      }
    }

    return widthOfBinaryTree(tempQueue, max);
  }

  private void trimQueue(Deque<TreeNode> queue) {
    while(!queue.isEmpty() && queue.peekFirst() == null) {
      queue.removeFirst();
    }
    while(!queue.isEmpty() && queue.peekLast() == null) {
      queue.removeLast();
    }

  }

  public static void main(String[] args) {
    MaxWidth mw = new MaxWidth();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    int width = mw.widthOfBinaryTree(root);
    System.out.println(width);
  }

}
