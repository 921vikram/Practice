package dp;

import java.util.Vector;

public class CountNoOfSubSetWithdiff {


  public static void main(String args[]) {
    int[] wt = {1, 1, 2, 3};
    int sum = 0;
    for(int i =0; i< wt.length; i++) {
      sum = sum + wt[i];
    }
    if(sum %2 ==0) {
      System.out.println("diff 1 not possible");
      return;
    }
    // s1 -s2 = 1
    // s1 + s2 = sum
    // s2 = sum -1 /2;
    int s2 = (sum -1)/2;

    int W = s2;
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


    System.out.println("No of ub sets with diff 1  is "+t[n][W]);
  }
}
