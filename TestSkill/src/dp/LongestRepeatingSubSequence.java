package dp;

public class LongestRepeatingSubSequence {

  /**
   * Run LCS on 2 same String anc check for i ! j means at same index if same character is there it should not pick
   * @param args
   */
  public static void main(String args[]) {

    char[] X = {'a', 'a', 'b', 'e', 'b', 'c', 'd', 'd'};
    long t1 = System.currentTimeMillis();
    int n = X.length;
    int[][] t = new int[n + 1][n + 1];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n+1; i++) {
      for (int j = 1; j < n+1; j++) {
        if (X[i - 1] == X[j - 1] && i != j) {
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          int tmp1 = t[i][j - 1];
          int tmp2 = t[i - 1][j];
          t[i][j] = (tmp1 > tmp2 ? tmp1 : tmp2);
        }
      }
    }
    System.out.println("Time taken " + (System.currentTimeMillis() - t1));
    System.out.println("LCS length  " + t[n][n]);
  }


}
