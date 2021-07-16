package dp;

public class CoinChangeMaxWays {


  public static void main(String args[]) {
    int[] coins = {1, 2, 3};
    int W = 5;
    int n = coins.length;
    int[][] t = new int[n + 1][W + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < W + 1; j++) {
        if(i == 0) {
          t[i][j] = 0;
        }
        if (j == 0) {
          t[i][j] = 1;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < W + 1; j++) {
        if (coins[i - 1] <= j) {
          int tmp1 = t[i][j - coins[i - 1]];
          int tmp2 = t[i - 1][j];
          t[i][j] = tmp1 + tmp2;
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }

    System.out.println("maximum ways to get sum of coin 5 is  " + t[n][W]);
  }
}
