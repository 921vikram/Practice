package graph;

import stack.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class NumberOffIslandDFS {

  private static int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String args[]) {

    int[][] s = new int[][]{{1, 1, 0, 1}, {0, 0, 1, 0}, {0, 0, 0, 0}, {1, 1, 0, 0}};


    if (s.length == 0) {
      return;
    }
    if (s[0].length == 0) {
      return;
    }
    int noOfIslands = 0;

    for (int i = 0; i < s.length; i++) {
      for (int j = 0; j < s[0].length; j++) {
        if (s[i][j] == 1) {
          visitNodes(s, i, j, s.length, s[0].length);
          noOfIslands++;
        }
      }
    }
    System.out.println("Number of Islands " + noOfIslands);
  }

  private static void visitNodes(int[][] s, int i, int j, int length, int length1) {
    if (i < 0 || j < 0 || i > length - 1 || j > length1 - 1 || s[i][j] != 1) {
      return;
    }
    s[i][j] = 2;
    for (int k = 0; k < direction.length; k++) {
      visitNodes(s, i + direction[k][0], j + direction[k][1], length, length1);
    }
  }

}
