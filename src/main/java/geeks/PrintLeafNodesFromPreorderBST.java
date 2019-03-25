package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;


/**
 * Created by kreddy on 2/14/18.
 */
public class PrintLeafNodesFromPreorderBST {

  public static void main (String[] args) {
    //code
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int[] input = new int[sc.nextInt()];
      for (int i = 0; i < input.length; i++) {
        input[i] = sc.nextInt();
      }
      printLeafNodesInOrder(input);
    }
  }

  private static void printLeafNodesInOrder(int[] input) {
    if (null == input || input.length == 0) {
      return;
    }
    Deque<Integer> stack = new ArrayDeque<>();
    int previous = Integer.MAX_VALUE;
    for (int i = 0; i < input.length; i++) {
      if (input[i] < previous) {
        stack.push(input[i]);
      } else {
        printLeaf(stack, input[i]);
      }
      previous = input[i];
    }
    System.out.println(previous);
  }

  private static void printLeaf(Deque<Integer> stack, int num) {
//    int previous = Integer.MAX_VALUE;
    if (!stack.isEmpty()) {
      int previous = stack.pop();
      int current = Integer.MAX_VALUE;
      while (!stack.isEmpty() && stack.peek() < num) {
        current = stack.pop();
      }
      if (current < num) {
        System.out.print(previous + " ");
      }
    }
    stack.push(num);

    /*while (! stack.isEmpty()) {
      int cur = stack.peek();
      if (cur < num) {
        if (previous < cur) {
          System.out.print(previous + " ");
        } else {
          previous = cur;
          stack.pop();
        }
      }
    }*/
  }

}
