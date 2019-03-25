package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.Point;

/**
 * Created by kreddy on 2/20/18.
 */
public class WordBoggle {

  public static void main (String[] args) {
    //code
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while(tc-- > 0) {
      int wc = sc.nextInt();
      Set<String> dict = new HashSet<String>();
      while (wc-- > 0) {
        dict.add(sc.next());
      }
      int r = sc.nextInt();
      int c = sc.nextInt();
      String[][] chars = new String[r][c];
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          chars[i][j] = sc.next();
        }
      }

      Set<String> found = dfs(chars, dict);
    }
  }

  private static Set<String> dfs(String[][] chars, Set<String> dict) {
    Set<String> found = new TreeSet<String>();
    Set<Point> cache = new HashSet<Point>();
    Point p = null;
    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars[0].length; j++) {
        p = new Point(i, j);
        cache.add(p);
        dfs(chars, dict, chars[i][j], p, cache, found);
        cache.remove(p);
      }
    }
    return found;
  }

  private static void dfs(String[][] chars,
      Set<String> dict,
      String prefix,
      Point p,
      Set<Point> cache,
      Set<String> found) {
    if (dict.contains(prefix)) {
      found.add(prefix);
    }
    List<Point> adjcts = getAdjacentPoints(p, chars.length, chars[0].length);

    for (Point ap : adjcts) {
      if (!cache.contains(ap)) {
        cache.add(ap);
        dfs(chars, dict, prefix + chars[(int)p.getX()][(int)p.getY()], ap, cache, found);
        cache.remove(ap);
      }
    }
    //return found;
  }

  private static List<Point> getAdjacentPoints(Point p, int r, int c) {
    List<Point> list = new ArrayList<Point>();
    int x = (int)p.getX();
    int y = (int)p.getY();
    for (int i = x - 1; i <= x + 1; i++) {
      for (int j = y - 1; j <= y + 1; j++) {
        if (i >= 0 && i < r && j >= 0 && j < c && !(i == x && j == y)) {
          list.add(new Point(i, j));
        }
      }
    }
    return list;
  }
}
