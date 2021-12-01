package recursion;

public class CountWaysToReachNthStairs {

  public static void main(String[] args)
  {
    int s = 5, m = 2;
    System.out.println("Number of ways = " + countWays(s, m));
  }

  private static int countWays(int s, int m) {
    return countWaysUtil(s+1, m);
  }

  private static int countWaysUtil(int s, int m) {
    int[] res = new int[s+1];
    res[0] = 1;
    res[1] = 1;

    for(int i =2; i< s;i++) {
      res[i] = 0;
      for(int j = 1; j<=m && j<=i; j++) {
        res[i] = res[i] + res[i-j];
      }
    }
    return res[s-1];
  }
}
