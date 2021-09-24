import java.util.Arrays;

/**
 * abcbad
 * largest sub string which is palindrome
 * <p>
 * abcbad
 * <p>
 * dabcba
 */
public class LongestPalindromeString {

  public static void main(String args[]) {

    String a = "abcbad";
    char[] a1 = a.toCharArray();
    int len = findLongestSubstring(a1);
    System.out.println(" longenst lenght : " + len);
  }

  private static int findLongestSubstring(char[] arr) {

    int n = arr.length;
    boolean[][] dp = new boolean[n + 1][n + 1];
    int maxLength = 0;

    // Conditions
    // 1. boundary should match
    // 2. also sub problem will be palindrome dp[i+1][j-1]

    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
    }

    // 2 length substring
    for (int i = 0; i < n - 2; i++) {
      if (arr[i] == arr[i + 1]) {
        dp[i][i + 1] = true;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 2; j < n; j++) {
        if (arr[i] == arr[j] || dp[i + 1][j - 1]) {
          maxLength = Math.max(maxLength, j-i+1);
          dp[i][j] = true;
        }
      }
    }

    return maxLength;

//    int maxLength = 0;
//    for (int i = 1; i < arr.length - 1; i++) {
//      // for each i we will find longest palindrome
//      int tmpLength = getLengthOfPalindrome(arr, i);
//      maxLength = Math.max(tmpLength, maxLength);
//    }
//    return maxLength;
  }


//  private static int getLengthOfPalindrome(char[] arr, int m) {
//    int length = 0;
//    int i = m - 1;
//    int j = m + 1;
//    int n = arr.length;
//    while (i >= 0 && j <= n - 1) {
//      if (arr[i] != arr[j]) {
//        return length;
//      } else {
//        length = +2;
//      }
//      i--;
//      j++;
//    }
//    return length;
//  }


}
