package dp;

import java.util.Arrays;

public class LCSMemoization {

  private static int[][] t = new int[30][30];

  public static void main(String args[]) {
    Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));

    char[]  X = {'a','b','c','d','g','h','a','b','c','d','g','h','a','b','g','h','a','b','t','a','b','g','h','t','b','l','p'};
    char[]  Y = {'a','b','e','d','f','h','a','b','e','d','f','h','a','g','h','a','b','c','n','d','f','h','a','n','y','f','o'};
    long t1 = System.currentTimeMillis();
    int res = LCS(X, Y, X.length, Y.length);
    System.out.println("Time taken "+(System.currentTimeMillis() - t1));
    System.out.println("LCS length  " + res);
  }

  public static int LCS(char[] X, char[] Y, int n, int m) {
    if(t[n][m] != -1) {
      return t[n][m];
    }
    if (m == 0 || n == 0) {
      return 0;
    }
    if(X[n-1] == Y[m-1]) {
      t[n-1][m-1] = LCS(X,Y,n-1, m-1);
      return t[n][m] = 1+ t[n-1][m-1];
    } else {
      int tmp1 = LCS(X, Y, n-1, m);
      t[n-1][m] = tmp1;
      int tmp2 = LCS(X, Y, n, m-1);
      t[n][m-1] = tmp2;
      return t[n][m] =  Math.max(tmp1, tmp2);
    }
  }

}
