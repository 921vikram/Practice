package dp;

/**
 * Minimum number of insertion to make string to palindrome is same as number of deletion
 */
public class MinInsertionPalindrom {


  public static void main(String args[]) {

    char[] X = {'a', 'g', 'b', 'c', 'b', 'a'};
    char[] Y = new char[X.length];
    long t1 = System.currentTimeMillis();
    int n = X.length;
    for (int i = X.length - 1; i >= 0; i--) {
      Y[X.length - i - 1] = X[i];
    }
    int m = Y.length;
    int[][] t = new int[n + 1][m + 1];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (X[i - 1] == Y[j - 1]) {
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          int tmp1 = t[i][j - 1];
          int tmp2 = t[i - 1][j];
          t[i][j] = (tmp1 > tmp2 ? tmp1 : tmp2);
        }
      }
    }
    System.out.println("Time taken " + (System.currentTimeMillis() - t1));
    System.out.println("Longest common Palindromic sequence  " + t[n][m]);
    System.out.println("Minimum number of deletion to make String palindrome  " + (X.length - t[n][m]));
    System.out.println("Minimum number of insertion to make String palindrome  " + (X.length - t[n][m]));
  }
}