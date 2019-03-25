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
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

/* Name of the class has to be "Main" only if the class is public. */
public class DepthOfTree
{
  public static void main (String[] args) throws java.lang.Exception
  {
    int[] input = new int[]{-1, 0, 1, 6, 6, 0, 0, 2, 7};
    int[] depth = new int[input.length];

    for(int i = 0; i < input.length; i++) {
      if (depth[i] == 0) {
        depth[i] = getDepth(i, input, depth);
      }
    }
    for (int i = 0; i < depth.length; i++) {
      System.out.print(depth[i]);
    }
    System.out.println();
    IntStream stream = IntStream.of(depth);
    OptionalInt max = stream.reduce(Integer::max);
    System.out.println(max.getAsInt());
  }

  private static int getDepth(int i, int[] input, int[] depth) {
    if (depth[i] != 0) {
      return depth[i];
    }
    if (input[i] == -1) {
      return 0;
    }
    depth[i] = 1 + getDepth(input[i], input, depth);
    return depth[i];
  }
}
