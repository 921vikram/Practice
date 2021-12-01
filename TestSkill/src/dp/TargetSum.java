package dp;

import java.util.Arrays;

public class TargetSum {

  private static int findTargetSumWays(int[] arr, int s) {
    int[][] dp = new int[arr.length+1][2001];
    Arrays.stream(dp).forEach(x -> Arrays.fill(x, Integer.MIN_VALUE));
    return backTrack(arr,0,0,s,dp);
  }

  private static int backTrack(int[] arr, int index, int sum, int s, int[][] dp) {
    if(index == arr.length) {
      return sum == s ? 1 : 0;
    }

    if(dp[index][sum + 1000] != Integer.MIN_VALUE) {
      return dp[index][sum + 1000];
    }

    int ans = backTrack(arr, index +1, sum + arr[index] , s,  dp) +
      backTrack(arr, index +1, sum - arr[index] , s, dp);

    dp[index][sum + 1000] = ans;
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1,1,1,1,1};
    int res = findTargetSumWays(arr,3);
    System.out.println("Find number of ways : "+res);
  }

}
