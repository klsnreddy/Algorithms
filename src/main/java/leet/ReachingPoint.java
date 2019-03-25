package leet;

import edu.princeton.cs.algs4.In;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by kreddy on 2/10/18.
 */
public class ReachingPoint {

  public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
    return reachingPoints(sx, sy, tx, ty, new HashMap<>());
  }

  public static boolean reachingPoints(int sx, int sy, int tx, int ty, Map<String, Boolean> notReachable) {
    if (sx == tx && sy == ty)
      return true;
    if (sx > tx || sy > ty)
      return false;
    if(notReachable.get(sx + "-" + sy) != null && notReachable.get(sx + "-" + sy))
      return false;
    if (reachingPoints(sx + sy, sy, tx, ty))
      return true;
    notReachable.put(sx + sy + "-" + sy, true);
    if(reachingPoints(sx, sx + sy, tx, ty))
      return true;
    notReachable.put(sx + "-" + (sx + sy), true);
    return false;
  }

  public static boolean reachingPointsNew(int sx, int sy, int tx, int ty) {
    if (sx == tx && sy == ty)
      return true;
    if (sx > tx || sy > ty)
      return false;

    LinkedList<Integer> xQueue = new LinkedList<>();
    LinkedList<Integer> yQueue = new LinkedList<>();
    xQueue.add(sx);
    yQueue.add(sy);
    Integer qx = null;
    Integer qy = null;
    while (!xQueue.isEmpty()) {
      qx = xQueue.removeFirst();
      qy = yQueue.removeFirst();
      if (qx == tx && qy == ty)
        return true;
      if (qx > tx || qy > ty)
        continue;
      xQueue.addLast(qx + qy);
      yQueue.addLast(qy);
      xQueue.addLast(qx);
      yQueue.addLast(qx + qy);
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(reachingPointsNew(1, 1, 1, 1));
    System.out.println(reachingPointsNew(1, 1, 2, 2));
    System.out.println(reachingPointsNew(1, 1, 3, 5));
    System.out.println(reachingPointsNew(35, 13, 455955547, 420098884));
  }
}
