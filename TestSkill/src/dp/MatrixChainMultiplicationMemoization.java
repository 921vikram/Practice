package dp;

import java.util.Arrays;

public class MatrixChainMultiplicationMemoization {

  private static int[][] t = new int[30][30];

  public static void main(String args[]) {
    Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));

    //int[] X = {40, 20, 30, 10, 30};
    int[] X = {40, 20, 30, 10, 30, 30, 50,60, 30, 20, 50, 30, 40, 30, 60, 40, 40,10,30,60,10,30};
    long t1 = System.currentTimeMillis();
    int i = 0;
    int j = X.length - 1;
    int cost = solve(X,1,j);
    System.out.println("Time taken " + (System.currentTimeMillis() - t1));
    System.out.println("Minimum Matrix multiplication cost  " + cost);
    //
  }

  private static int solve(int[] x, int i, int j) {
    if(t[i][j] != -1) {
      return t[i][j];
    }
    if (i >= j) {
      return 0;
    }
    int mn = Integer.MAX_VALUE;
    for(int k=i; k<j;k++) {
      int tmp1 = solve(x,i, k);
      //t[i][k] = tmp1;
      int tmp2 = solve(x,k+1, j);
      //t[k+1][j] = tmp2;
      int tempAns = tmp1  + tmp2 + (x[i-1]*x[k]*x[j]);
      if(tempAns < mn) {
        mn = tempAns;
      }
    }
    return t[i][j] = mn;
  }

}
