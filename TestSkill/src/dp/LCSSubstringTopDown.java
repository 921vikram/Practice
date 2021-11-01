package dp;

/**
 * FInd length of maximum sub-string from given 2 strings
 */
public class LCSSubstringTopDown {


  public static void main(String args[]) {

//    char[] X = {'a', 'b', 'c', 'd', 'g', 'h', 'a', 'b', 'c', 'd', 'g', 'h', 'a', 'b', 'g', 'h', 'a', 'b', 't', 'a', 'b', 'g', 'h', 't', 'b', 'l', 'p'};
//    char[] Y = {'a', 'b', 'e', 'd', 'f', 'h', 'a', 'b', 'e', 'd', 'f', 'h', 'a', 'g', 'h', 'a', 'b', 'c', 'n', 'd', 'f', 'h', 'a', 'n', 'y', 'f', 'o'};
    char[] X = {'a', 'b', 'c', 'd', 'e'};
    char[] Y = {'a', 'b', 'f', 'c', 'e'};
    long t1 = System.currentTimeMillis();
    int n = X.length;
    int m = Y.length;
    int[][] t = new int[n + 1][m + 1];

    /**
     * Base Condition where if length of both String is 0 then length of maximum sub string will be 0 only
     */
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }

    /**
     * if
     */
    int result = -1;
    for (int i = 1; i < n+1; i++) {
      for (int j = 1; j < m+1; j++) {
        if (X[i - 1] == Y[j - 1]) {
          t[i][j] = 1 + t[i - 1][j - 1];
          result = Integer.max(result, t[i][j]);
        } else {
          t[i][j] = 0;
        }
      }
    }
    System.out.println("Time taken " + (System.currentTimeMillis() - t1));
    System.out.println("Longest common substring  length  " + result);
  }


}
