package dp;

public class StringInterlevedOtherTwoString {
  // Driver code
  public static void main(String[] args) {
    test("XXY", "XXZ", "XXZXXXY");
    test("XY", "WZ", "WZXY");
    test("XY", "X", "XXY");
    test("YX", "X", "XXY");
    test("XXY", "XXZ", "XXXXZY");
  }

  static void test(String A, String B, String C) {
    if (isInterleaved(A, B, C))
      System.out.println(C + " is interleaved of " + A + " and " + B);
    else
      System.out.println(C + " is not interleaved of " + A + " and " + B);
  }

  private static boolean isInterleaved(String a, String b, String c) {
    int m = a.length();
    int n = b.length();

    boolean[][] dp = new boolean[m + 1][n + 1];

    if (m + n != c.length()) {
      return false;
    }

    for (int i = 0; i < m+1; i++) {
      for (int j = 0; j < n+1; j++) {

        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (i == 0) {
          dp[i][j] = b.charAt(j - 1) == c.charAt(j - 1) ? dp[i][j - 1] : false;
        } else if (j == 0) {
          dp[i][j] = a.charAt(i - 1) == c.charAt(i - 1) ? dp[i - 1][j] : false;
        } else if (a.charAt(i - 1) == c.charAt(i + j - 1) && b.charAt(j - 1) != c.charAt(i + j - 1)) {
          // matches with A but not with B
          dp[i][j] = dp[i - 1][j];
        } else if (a.charAt(i - 1) != c.charAt(i + j - 1) && b.charAt(j - 1) == c.charAt(i + j - 1)) {
          // matches with B but not with A
          dp[i][j] = dp[i][j - 1];
        } else if (a.charAt(i - 1) == c.charAt(i + j - 1) && b.charAt(j - 1) == c.charAt(i + j - 1)) {
          // matches with B and  with A
          dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
        }
      }
    }
    return dp[m][n];
  }


}
