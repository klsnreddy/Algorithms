package leet;

/**
 * Created by kreddy on 5/4/18.
 */
public class SquirrelSimulation {

  public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
    int[] r = null;
    int[] p = null;
    int distance = Integer.MIN_VALUE;
    int maxSave = Integer.MIN_VALUE;
    for (int i = 0; i < nuts.length; i++) {
      p = nuts[i];
      int treeDist = dist(p[0], p[1], tree[0], tree[1]);
      int sqlDist = dist(p[0], p[1], squirrel[0], squirrel[1]);
      if(maxSave < treeDist - sqlDist) {
        maxSave = treeDist - sqlDist;
        distance = treeDist + sqlDist;
        r = p;
      }
    }

    boolean found = false;
    for (int i = 0; i < nuts.length; i++) {
      p = nuts[i];
      if (p[0] == r[0] && p[1] == r[1] && !found) {
        found = true;
        continue;
      }
      distance += 2 * dist(p[0], p[1], tree[0], tree[1]);
    }

    return distance;
  }


  private int dist(int r1, int c1, int r2, int c2) {
    return Math.abs(r1-r2) + Math.abs(c1-c2);
  }

  public static void main(String[] args) {
    SquirrelSimulation ss = new SquirrelSimulation();

    System.out.println(ss.minDistance(5, 7, new int[]{2,2}, new int[]{4,4}, new int[][]{{3,0}, {2,5}}));
    System.out.println(ss.minDistance(5, 5, new int[]{3,2}, new int[]{0,1},
        new int[][]{{2,0},{4,1},{0,4},{1,3},{1,0},{3,4},{3,0},{2,3},{0,2},{0,0},{2,2},{4,2},{3,3},{4,4},{4,0},{4,3},{3,1},{2,1},{1,4},{2,4}}));
  }
}
