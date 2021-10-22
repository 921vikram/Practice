package graph;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfConnectedColorDFS {

  private static int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private static Map<Integer, Integer> colorCount = new HashMap<>();

  public static void main(String args[]) {

    // 1, 2, 3 represent different colors
    // Visited means -1
    int[][] s = new int[][]{{1, 1, 0, 2}, {1, 3, 2, 2}, {3, 3, 0, 3}, {2, 3, 3, 3}};


    if (s.length == 0) {
      return;
    }
    if (s[0].length == 0) {
      return;
    }

    for (int i = 0; i < s.length; i++) {
      for (int j = 0; j < s[0].length; j++) {
        if (s[i][j] >= 1) {
          int color = s[i][j];
          Integer oldValue = colorCount.get(color);
          colorCount.put(color, 0);
          visitNodes(s, i, j, s.length, s[0].length, color);
          Integer newValue = colorCount.get(color);
          if(null != oldValue && null != newValue && newValue < oldValue) {
            colorCount.put(color, oldValue);
          }
        }
      }
    }
    for(int key : colorCount.keySet()) {
      System.out.println(" Colour "+key+ " count : "+colorCount.get(key));
    }
  }

  private static void visitNodes(int[][] s, int i, int j, int length, int length1, int color) {
    if (i < 0 || j < 0 || i > length - 1 || j > length1 - 1 || s[i][j] == -1) {
      return;
    }
    if(color == s[i][j]) {
      s[i][j] = -1;
      colorCount.put(color, colorCount.get(color)+1);
      for (int k = 0; k < direction.length; k++) {
        visitNodes(s, i + direction[k][0], j + direction[k][1], length, length1, color);
      }
    }
  }

}
