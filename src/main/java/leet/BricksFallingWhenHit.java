package leet;

public class BricksFallingWhenHit {

  public int[] hitBricks(int[][] grid, int[][] hits) {
    int[] result = new int[hits.length];

    for (int i = 0; i < hits.length; i++) {
      grid[hits[i][0]][hits[i][1]] = 0;
      result[i] = getDrops(grid);
    }

    return result;
  }

  private int getDrops(int[][] grid) {
    boolean[][] connected = new boolean[grid.length][grid[0].length];
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < n; i++) {
      if (grid[0][i] == 1 && !connected[0][i]) {
        markConencted(grid, connected, 0, i);
      }
    }

    int count = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && !connected[i][j]) {
          count++;
          grid[i][j] = 0;
        }
      }
    }

    return count;
  }

  private void markConencted(int[][] grid, boolean[][] connected, int r, int c) {
    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
      connected[r][c] = true;
    }

    if (r - 1 >= 0 && grid[r-1][c] == 1 && !connected[r-1][c]) {
      markConencted(grid, connected, r-1, c);
    }

    if (r + 1 < grid.length && grid[r+1][c] == 1 && !connected[r+1][c]) {
      markConencted(grid, connected, r+1, c);
    }

    if (c - 1 >= 0 && grid[r][c-1] == 1 && !connected[r][c-1]) {
      markConencted(grid, connected, r, c-1);
    }

    if (c + 1 < grid[0].length && grid[r][c+1] == 1 && !connected[r][c+1]) {
      markConencted(grid, connected, r, c+1);
    }
  }

  public static void main(String[] args) {
    

  }
}
