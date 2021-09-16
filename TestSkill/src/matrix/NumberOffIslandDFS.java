package matrix;

import stack.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class NumberOffIslandDFS {

  public static void main(String args[]) {

    int[][] s = new int[][]{{1,1,0,1}, {0,0,1,0}, {0,0,0,0}, {1,1,0,0}};
    if(s.length == 0) {
      return;
    }
    if(s[0].length == 0) {
      return;
    }
    int noOfIslands = 0;

    for(int i=0; i<s.length; i++) {
      for (int j = 0; j < s[0].length; j++) {
        if (s[i][j] == 1) {
          visitNodes(s, i, j, s.length, s[0].length);
          noOfIslands++;
        }
      }
    }
    System.out.println("Number of Islands " +noOfIslands);
  }

  private static void visitNodes(int[][] s, int i, int j, int length, int length1) {
    if(i<0 || j<0 || i> length-1 || j > length1-1 || s[i][j] !=1) {
      return;
    }
    s[i][j] = 2;
    visitNodes(s,i+1,j,length,length1);
    visitNodes(s,i-1,j,length,length1);
    visitNodes(s,i,j+1,length,length1);
    visitNodes(s,i,j-1,length,length1);
  }

}
