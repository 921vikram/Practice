package recursion;

import java.util.Arrays;

public class CountPossibleDecoding {

  static int countWays(char[] digits) {

    int n = digits.length;
    if(n ==0 || n==1 || digits[0] == '0') {
      return 0;
    }
    int[] counts = new int[n+1];
    Arrays.fill(counts, -1);
    return countDecoding(digits, n, counts);
  }

  private static int countDecoding(char[] digits, int n, int[] counts) {
    if(counts[n] != -1) {
      return counts[n];
    }
    if(n ==0 || n==1) {
      return 1;
    }

    if(digits[0] == '0') {
      return 0;
    }

    int count = 0;

    if(digits[n-1] > '0') {
      count = countDecoding(digits, n-1, counts);
    }

    if(digits[n-2] == '1' || (digits[n-2] == '2' && digits[n-1] < '7')) {
      count += countDecoding(digits, n-2, counts);
    }
    return counts[n] = count;
  }

  // Driver code
  public static void main(String[] args)
  {
    char digits[] = { '1', '2', '3', '4' };
    System.out.printf("Count is %d",
      countWays(digits));
  }
}
