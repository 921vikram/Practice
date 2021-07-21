package dp;

import java.util.Arrays;

public class PalindromPartitioningMCMMemoization {

  private static int[][] t = new int[6][6];

  public static void main(String args[]) {
    Arrays.stream(t).forEach(a->Arrays.fill(a, -1));
    char[] X = {'n','i','t', 'i', 'm'};
    long t1 = System.currentTimeMillis();
    int cost = solve(X,0, X.length-1);
    System.out.println("Time taken " + (System.currentTimeMillis() - t1));
    System.out.println("Minimum Partitioning cost  " + cost);
    //
  }

  private static int solve(char[] x, int i, int j) {
    if(t[i][j] != -1) {
      return t[i][j];
    }
    if (i >= j) {
      return 0;
    }
    if(isPalindrom(x,i,j)) {
      return 0;
    }
    int mn = Integer.MAX_VALUE;
    for(int k=i; k<j;k++) {
      int left = -1;
      if(t[i][k] != -1) {
        left = t[i][k];
      } else {
        left = solve(x,i,k);
      }
      int right = -1;
      if(t[k+1][j] != -1) {
        right =  t[k+1][j];
      } else {
        right = solve(x,k+1,j);
      }
      int tempAns = 1 + left + right;
      if(tempAns < mn) {
        mn = tempAns;
      }
    }
    return t[i][j] = mn;
  }

  private static boolean isPalindrom(char[] x, int i, int j) {
    while (i<j) {
      if(x[i] != x[j]) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }




}
