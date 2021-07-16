package dp;

import java.util.Arrays;

public class Knapsack {

  public static void main(String args[]) {
    int[] wt = {1, 3, 4, 5};
    int[] value = {1, 4, 5, 7};
    int W = 10;
    int res = knapsack(wt, value, W, wt.length);
    System.out.println("knapsack " + res);
  }

  public static int knapsack(int[] wt, int[] value, int W, int n) {
    if (n == 0 || W == 0) {
      return 0;
    }
    if (wt[n - 1] <= W) {
      int tmp1 = value[n - 1] + knapsack(wt, value, W - wt[n - 1], n - 1);
      int tmp2 = knapsack(wt, value, W, n - 1);
      return tmp1 > tmp2 ? tmp1 : tmp2;
    } else if (wt[n - 1] > W) {
      return  knapsack(wt, value, W, n - 1);
    }
    return -1;
  }


}
