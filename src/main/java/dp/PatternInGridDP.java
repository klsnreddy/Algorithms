package dp;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PatternInGridDP {

  private static int count = 0;

  public static boolean isPatternInGrid(int[][] grid, int[] pattern) {
    count = 0;
    boolean result = false;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    Set<Attempt> notContains = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (isPatternInGrid(grid, pattern, 0, 0, 0, visited, notContains))
          result = true;
      }
    }
    System.out.println(count);
    return result;
  }

  private static boolean isPatternInGrid(int[][] grid, int[] pattern, int i, int j,
      int idx, boolean[][] visited, Set<Attempt> notContains) {
    if (pattern.length == idx)
      return true;

    Attempt a = new Attempt(i, j, idx);
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||
        grid[i][j] != pattern[idx] || visited[i][j] || notContains.contains(a)) {
      return false;
    }

    visited[i][j] = true;
    count++;
    boolean result = isPatternInGrid(grid, pattern, i - 1, j, idx + 1, visited, notContains) ||
        isPatternInGrid(grid, pattern, i + 1, j, idx + 1, visited, notContains) ||
        isPatternInGrid(grid, pattern, i, j - 1, idx + 1, visited, notContains) ||
        isPatternInGrid(grid, pattern, i, j + 1, idx + 1, visited, notContains);

    if (!result) {
      notContains.add(new Attempt(i, j, idx));
    }
    visited[i][j] = false;
    return result;
  }

  private static class Attempt {
    private Integer i, j, idx;

    public Attempt(int i, int j, int idx) {
      this.i = i;
      this.j = j;
      this.idx = idx;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j, idx);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this)
        return true;
      if (null == obj || this.getClass() != obj.getClass())
        return false;

      Attempt o = (Attempt) obj;

      if (this.i == o.i && this.j == o.j && this.idx == o.idx)
        return true;
      return false;
    }
  }
}
