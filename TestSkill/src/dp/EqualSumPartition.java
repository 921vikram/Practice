package dp;

public class EqualSumPartition {


  public static void main(String args[]) {
    int[] wt = {1, 5, 11, 5};
    int sum = 0;
    for(int i =0; i< wt.length; i++) {
      sum = sum + wt[i];
    }
    if(sum %2 != 0) {
      System.out.println("No partition");
    }
    int W = sum /2;
    int n = wt.length;
    boolean[][] t = new boolean[n+1][W+1];

    for (int i = 0; i < n+1; i++) {
      for (int j = 0; j < W+1; j++) {
        if (i == 0) {
          t[i][j] = false;
        }
        if (j ==0) {
          t[i][j] = true;
        }
      }
    }

    for (int i = 1; i < n+1; i++) {
      for (int j = 1; j < W+1; j++) {
        if (wt[i - 1] <= j) {
          boolean tmp1 = t[i - 1][j - wt[i - 1]];
          boolean tmp2 = t[i - 1][j];
          t[i][j] = tmp1 | tmp2;
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }

    System.out.println("knapsack "+t[n][W]);
  }
}
