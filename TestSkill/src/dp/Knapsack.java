package dp;

import java.util.Arrays;

public class Knapsack {

  private static int[][] t = new int[5][11];

  public static void main(String args[]) {
    Arrays.fill(t, -1);
    int[] wt = {1, 3, 4, 5};
    int[] value = {1, 4, 5, 7};
    int W = 10;
    int res = knapsack(wt, value, W, wt.length);
    System.out.println("knapsack " + res);
  }

  public static int knapsack(int[] wt, int[] value, int W, int n) {
    if(t[n][W] != -1) {
      return t[n][W];
    }
    if (n == 0 || W == 0) {
      return 0;
    }
    if (wt[n - 1] <= W) {
      t[n-1][W-wt[n-1]] = knapsack(wt, value, W - wt[n - 1], n - 1);
      int tmp1 = value[n - 1] + t[n-1][W-wt[n-1]];
      int tmp2 = knapsack(wt, value, W, n - 1);
      t[n-1][W] = tmp2;
      return tmp1 > tmp2 ? tmp1 : tmp2;
    } else if (wt[n - 1] > W) {
      t[n-1][W] = knapsack(wt, value, W, n - 1);
      return t[n-1][W];
    }
    return -1;
  }


}
