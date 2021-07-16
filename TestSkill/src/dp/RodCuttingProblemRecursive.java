package dp;

import java.util.Arrays;

public class RodCuttingProblemRecursive {

  private static int[][] t = new int[9][9];

  public static void main(String args[]) {
    Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));
    int[] length = {1, 2, 3, 4, 5,6,7,8};
    int[] value =  {1, 5, 8, 9,10,17,17,20};
    int W = 8;
    int res = knapsack(length, value, W, length.length);
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
      int tmp1 = value[n-1] + knapsack(wt, value, W - wt[n - 1], n );
      t[n][W-wt[n-1]] = tmp1;
      int tmp2 = knapsack(wt, value, W, n - 1);
      t[n-1][W] = tmp2;
      t[n][W]  = tmp1 > tmp2 ? tmp1 : tmp2;
      return t[n][W];
    } else if (wt[n - 1] > W) {
      t[n-1][W] = knapsack(wt, value, W, n - 1);
      t[n][W] =  t[n-1][W];
      return t[n][W];
    }
    return -1;
  }


}
