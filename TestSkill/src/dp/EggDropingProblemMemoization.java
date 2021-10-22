package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EggDropingProblemMemoization {

  public static int[][] t = new int[26][4];

  public static void main(String args[]) {
    Arrays.stream(t).forEach(a->Arrays.fill(a, -1));
    int f = 20;
    int e = 3;
    long t1 = System.nanoTime();
    int floor = solve(f, e);
    System.out.println("Time taken " + (System.nanoTime() - t1) / 1000);
    System.out.println("floor number " + floor);
  }


  private static int solve(int f, int e) {
    if(t[f][e] != -1) {
      return t[f][e];
    }
    if (e == 1) {
      return f;
    }
    if (f == 0 || f == 1) {
      return f;
    }
    int mn = Integer.MAX_VALUE;
    for (int i = 1; i <= f; i++) {
      int temp1 = -1;
      if(t[i-1][e-1] == -1) {
        temp1 = solve(i-1, e - 1);
      } else {
        temp1 = t[i-1][e-1];
      }
      int temp2 = -1;
      if(t[f-i][e] == -1) {
        temp2 = solve(f-i, e);
      } else {
        temp2 = t[f-i][e];
      }
      int temp = 1 + Math.max(temp1, temp2);
      mn = Math.min(temp, mn);
    }
    return t[f][e] = mn;
  }


}
