package dp;

public class RodCuttingTopDown {


  public static void main(String args[]) {
    int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] value = {1, 5, 8, 9, 10, 17, 17, 20};
    int W = 8;
    int n = length.length;
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
        if (length[i - 1] <= j) {
          int tmp1 = value[i - 1] + t[i][j - length[i - 1]];
          int tmp2 = t[i - 1][j];
          t[i][j] = Math.max(tmp1, tmp2);
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }

    System.out.println("knapsack " + t[n][W]);
  }
}
