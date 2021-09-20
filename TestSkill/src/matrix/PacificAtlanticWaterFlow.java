package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
  private static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
    List<List<Integer>> res = new ArrayList<>();
    // Base condition
    if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
      return res;
    }
    int row = matrix.length;
    int col = matrix[0].length;

    boolean[][] pacific = new boolean[row][col];
    boolean[][] atlantic = new boolean[row][col];

    for(int i=0; i< row; i++) {
      dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
      dfs(matrix, i ,col-1,Integer.MIN_VALUE, atlantic);
    }

    for(int i=0; i< col; i++) {
      dfs(matrix, 0, i,Integer.MIN_VALUE, pacific);
      dfs(matrix, row-1 ,i, Integer.MIN_VALUE, atlantic);
    }


    // Result
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          res.add(Arrays.asList(i, j));
        }
      }
    }

    return res;
  }

  private static void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean) {
    if(i < 0 || i >= matrix.length || j <0 || j>=matrix[0].length)
      return;
    if(ocean[i][j] || matrix[i][j] < prev)
      return;
    ocean[i][j] = true;
    for(int[] d : direction ) {
      dfs(matrix, i+d[0], j+d[1], matrix[i][j], ocean);
    }

  }

  public static void main(String args[]) {
  int[][] matrix =  new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
    List<List<Integer>> res = pacificAtlantic(matrix);
    res.stream().forEach(l -> System.out.print(l));
  }


}
