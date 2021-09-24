package recursion;

public class CountPossibleDecoding {

  static int countWays(char[] digits, int n) {
    if(n ==0 || n==1 || digits[0] == '0') {
      return 0;
    }
    return countDecoding(digits, n);
  }

  private static int countDecoding(char[] digits, int n) {
    if(n ==0 || n==1) {
      return 1;
    }

    if(digits[0] == '0') {
      return 0;
    }

    int count = 0;

    if(digits[n-1] > '0') {
      count = countDecoding(digits, n-1);
    }

    if(digits[n-2] == '1' || (digits[n-2] == '2' && digits[n-1] < '7')) {
      count += countDecoding(digits, n-2);
    }

    return count;
  }

  // Driver code
  public static void main(String[] args)
  {
    char digits[] = { '1', '2', '3', '4' };
    int n = digits.length;
    System.out.printf("Count is %d",
      countWays(digits, n));
  }
}
