package graph;

import java.util.ArrayDeque;

public class DungeonProblem {
  static int[] rowDir = new int[] {-1,1,0,0};
  static int[] colDir = new int[] {0,0,-1,1};
  static int rows = 5;
  static int cols = 7;

  public static void main(String[] args) {
    dungeon(rows, cols);
  }

  private static int dungeon(int row, int column) {
    boolean[][] visited = new boolean[row][column];

    char[][] matrix = new char[row][column];
    matrix[0] = new char[] {'S','.','.','#','.','.','.'};
    matrix[1] = new char[] {'.','#','.','.','.','#','.'};
    matrix[2] = new char[] {'.','#','.','.','.','.','.'};
    matrix[3] = new char[] {'.','.','#','#','.','.','.'};
    matrix[4] = new char[] {'#','.','#','E','.','#','.'};

    ArrayDeque<Integer> rowQueue = new ArrayDeque<Integer>();
    ArrayDeque<Integer> colQueue = new ArrayDeque<Integer>();

    int moveCount = 0;
    int itemsInTheNextLayer = 0;
    int itemsLefInTheLayer = 1;

    boolean reachedEnd = false;

    int sourceRow = 0;
    int sourceCol = 0;

    rowQueue.add(sourceRow);
    colQueue.add(sourceCol);

    visited[sourceRow][sourceCol] = true;

    while(!rowQueue.isEmpty()) {
      int tmpRow = rowQueue.removeFirst();
      int tmpCol = colQueue.removeFirst();

      if(matrix[tmpRow][tmpCol] == 'E') {
        reachedEnd = true;
        break;
      }

      for(int i = 0 ; i < 4; i++) {
        int effRow = tmpRow + rowDir[i];
        int effCol = tmpCol + colDir[i];

        if(effRow < 0 || effCol < 0) {
          continue;
        }

        if(effRow >= rows || effCol >= cols) {
          continue;
        }

        if(matrix[effRow][effCol] == '#') {
          continue;
        }

        if(visited[effRow][effCol]) {
          continue;
        }
        rowQueue.add(effRow);
        colQueue.add(effCol);
        visited[effRow][effCol] = true;
        itemsInTheNextLayer++;
      }

      itemsLefInTheLayer--;
      if(itemsLefInTheLayer == 0) {
        itemsLefInTheLayer = itemsInTheNextLayer;
        itemsInTheNextLayer = 0;
        moveCount++;
      }
    }
    if(reachedEnd) {
      return moveCount;
    }
    return -1;
  }


}
