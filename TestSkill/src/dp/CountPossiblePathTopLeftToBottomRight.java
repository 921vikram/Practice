package dp;

import java.util.Arrays;

public class CountPossiblePathTopLeftToBottomRight {


  public static void main(String args[]) {
    int m = 7;
    int n = 3;

    int[][] dp = new int[m][n];
    Arrays.stream(dp).forEach(a -> Arrays.fill(a, 0));

    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
      }
    }

    System.out.println("Possible paths "+dp[m-1][n-1]);

  }


}
