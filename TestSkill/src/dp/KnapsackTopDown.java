package dp;

public class KnapsackTopDown {


  public static void main(String args[]) {
    int[] wt = {1, 3, 4, 5};
    int[] value = {1, 4, 5, 7};
    int W = 16;
    int n = wt.length;
    int[][] t = new int[n + 1][W + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < W + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < W + 1; j++) {
        if (wt[i - 1] <= j) {
          int tmp1 = value[i - 1] + t[i - 1][j - wt[i - 1]];
          int tmp2 = t[i - 1][j];
          t[i][j] = tmp1 > tmp2 ? tmp1 : tmp2;
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }

    System.out.println("knapsack " + t[n][W]);
  }
}
