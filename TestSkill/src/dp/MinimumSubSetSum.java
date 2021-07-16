package dp;

import java.util.Vector;

public class MinimumSubSetSum {


  public static void main(String args[]) {
    int[] wt = {2, 3, 7};
    int sum = 0;
    for(int i =0; i< wt.length; i++) {
      sum = sum + wt[i];
    }
    int W = sum+1;
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
    Vector<Integer> array = new Vector<Integer>();
    for(int i=0; i<W/2;i++){
      if(t[n][i]) {
        array.add(i);
      }
    }
    int min = Integer.MAX_VALUE;
    for(int i=0; i<array.size();i++) {
      if(sum - (2*array.get(i)) < min) {
        min = sum - (2*array.get(i));
      }
    }
    System.out.println("Minimum subset sum Diff "+min);
  }
}
