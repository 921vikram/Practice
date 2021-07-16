package dp;

public class CountSubsetSum {


  public static void main(String args[]) {
    int[] wt = {2, 3,5,6,8,10};
    int W = 10;
    int n = wt.length;
    int[][] t = new int[n+1][W+1];

    for (int i = 0; i < n+1; i++) {
      for (int j = 0; j < W+1; j++) {
        if (i == 0) {
          t[i][j] = 0;
        }
        if (j ==0) {
          t[i][j] = 1;
        }
      }
    }

    for (int i = 1; i < n+1; i++) {
      for (int j = 1; j < W+1; j++) {
        if (wt[i - 1] <= j) {
          int tmp1 = t[i - 1][j - wt[i - 1]];
          int tmp2 = t[i - 1][j];
          t[i][j] = tmp1 + tmp2;
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }

    System.out.println("count subsets with sum "+t[n][W]);
  }
}
