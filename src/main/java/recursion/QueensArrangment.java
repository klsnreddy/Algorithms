package recursion;

import java.util.ArrayList;
import java.util.List;

public class QueensArrangment {

  private final int NO_OF_QUEENS;
  private List<List<Integer>> result = new ArrayList<>();

  public QueensArrangment(int NO_OF_QUEENS) {
    this.NO_OF_QUEENS = NO_OF_QUEENS;
  }

  public List<List<Integer>> getPositions() {

    if (!result.isEmpty())
      return result;
    arrangeQueens();
    return result;
  }

  private void arrangeQueens() {
    List<Integer> columns = new ArrayList<>();
    arrangeQueens(columns);
  }

  private void arrangeQueens(List<Integer> columns) {

    if (columns.size() == NO_OF_QUEENS) {
      if (isValid(columns)) {
        result.add(new ArrayList<>(columns));
      }
      return;
    }

    if (!isValid(columns)) {
      return;
    }

    for (int i = 0; i < NO_OF_QUEENS; i++) {
      columns.add(i);
      arrangeQueens(columns);
      columns.remove(columns.size() - 1);
    }
  }

  private boolean isValid(List<Integer> columns) {
    if (columns.size() > 1) {
      int row = columns.size() - 1;
      for (int i = 0; i < row; i++) {
        int diff = Math.abs(columns.get(row) - columns.get(i));
        if (diff == row - i || diff == 0) {
          return false;
        }
      }
    }
    return true;
  }

}
