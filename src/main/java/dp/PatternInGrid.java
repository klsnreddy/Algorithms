package dp;

public class PatternInGrid {

  private static int count = 0;

  public static boolean isPatternInGrid(int[][] grid, int[] pattern) {
    count = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    boolean result = false;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (isPatternInGrid(grid, pattern, 0, 0, 0, visited))
          result = true;
      }
    }
    System.out.println(count);
    return result;
  }

  private static boolean isPatternInGrid(int[][] grid, int[] pattern, int i, int j,
      int idx, boolean[][] visited) {
    if (pattern.length == idx)
      return true;

    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||
        grid[i][j] != pattern[idx] || visited[i][j]) {
      return false;
    }

    visited[i][j] = true;
    count++;
    boolean result = isPatternInGrid(grid, pattern, i - 1, j, idx + 1, visited) ||
        isPatternInGrid(grid, pattern, i + 1, j, idx + 1, visited) ||
        isPatternInGrid(grid, pattern, i, j - 1, idx + 1, visited) ||
        isPatternInGrid(grid, pattern, i, j + 1, idx + 1, visited);

    visited[i][j] = false;
    return result;
  }
}
