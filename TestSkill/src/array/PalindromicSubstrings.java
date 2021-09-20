package array;

import java.util.Arrays;

/**
 *
 */
public class PalindromicSubstrings {


  public static int isPal(String s, int i, int j, int dp[][]) {
    // Base condition
    if (i > j)
      return 1;

    // check if the recursive tree
    // for given i, j
    // has already been executed
    if (dp[i][j] != -1)
      return dp[i][j];

    // If first and last characters of
    // substring are unequal
    if (s.charAt(i) != s.charAt(j))
      return dp[i][j] = 0;

    // memoization
    return dp[i][j] = isPal(s, i + 1, j - 1, dp);
  }

  public static int countSubstrings(String s) {
    int dp[][] = new int[1001][1001]; // 2D matrix
    String[] palindroms = new String[1001];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    int n = s.length();

    // No. of palindrome of single character will be n
    int count = n;
    for(int i = 0; i < n; i++) {
      palindroms[i] = String.valueOf(s.charAt(i));
    }

    // 2 for loops are required to check for
    // all the palindromes in the string.
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        // Increment count for every palindrome
        if (isPal(s, i, j, dp) != 0) {
          palindroms[count] = s.substring(i, j + 1);
          count++;
        }
      }
    }
    for (int i = 0; i < count; i++) {
      System.out.println(" str : " + palindroms[i]);
    }
    // return total palindromic substrings
    return count;
  }

  public static void main(String[] args) {
    String s = "abc";
    System.out.println(countSubstrings(s));
  }

}
