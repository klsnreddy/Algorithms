package leet;

/**
 * Created by kreddy on 2/10/18.
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.

 Return the minimum number of rabbits that could be in the forest.

 Input: answers = [1, 1, 2]
 Output: 5
 */
public class RabbitsInJungle {

  public static int numRabbits(int[] answers) {
    int[] counts = new int[1000];
    for (int i : answers)
      counts[i]++;

    int minCount = counts[0];
    for (int i = 1; i < counts.length; i++) {
//      System.out.println(minCount);
//      System.out.println(counts[i]);
      if (counts[i] > i + 1) {
        minCount = (i + 1) * (counts[i] / (i+1)) + minCount;
        if (counts[i] % (i+1) != 0)
          minCount += (i + 1);
      } else if (counts[i] > 0) {
        minCount += (i + 1);
      }
    }
    return minCount;
  }

  public static void main(String[] args) {
    System.out.println(numRabbits(new int[]{1,1,2,2,2,2}));
  }

}
