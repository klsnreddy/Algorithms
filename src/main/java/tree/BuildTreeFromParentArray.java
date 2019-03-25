package tree;

/**
 * Created by kreddy on 9/13/17.
 */
/* package whatever; // don't place package name! */

/*
Given a parent array P, where P[i] indicates the parent of ith node in the tree (Parent of root node
is -1). Find the height or depth of the tree
EX: [-1, 0, 1, 6, 6, 0, 0, 2, 7]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Name of the class has to be "Main" only if the class is public. */
public class BuildTreeFromParentArray
{
  public static void main (String[] args) throws Exception
  {
    int[] input = new int[]{-1, 0, 1, 6, 6, 0, 0, 2, 7};
    Node[] nodes = new Node[input.length];
    Node root = null;
    for(int i = 0; i < input.length; i++) {
      if (null == nodes[i]) {
        constructTree(i, input, nodes);
      }
      if (input[i] == -1) {
        root = nodes[i];
      }
    }

    System.out.println(root.toString());

  }

  private static void constructTree(int i, int[] input, Node[] nodes) {
    if (nodes[i] == null) {
      if (null == nodes[i]) {
        nodes[i] = new Node(i);
      }

      if (input[i] == -1) {
        return;
      }

      constructTree(input[i], input, nodes);
      nodes[input[i]].addChild(nodes[i]);
    }
  }


  private static class Node<T> {

    private T val;
    private List<Node> children;

    Node(T val) {
      this.val = val;
      children = new ArrayList<Node>();
    }

    public void addChild(Node n) {
      children.add(n);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      Queue<Node> queue = new LinkedList<Node>();
      queue.offer(this);
      queue.offer(null);
      while(queue.peek() != null) {
        while(queue.peek() != null) {
          Node node = queue.poll();
          sb.append(node.val).append(" ");
          node.children.forEach(n -> queue.offer((Node)n));
        }
        queue.poll();
        sb.append("\n");
        queue.offer(null);
      }

      return sb.toString();
    }
  }
}
