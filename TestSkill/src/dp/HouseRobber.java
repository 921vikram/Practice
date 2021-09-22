package dp;

public class HouseRobber {

  public static void main(String args[]) {
    int[] s = {2, 7, 9, 3, 1};
    int max = maxRobbery(s);
    System.out.println("Maximum Robbery Amount : "+max);
  }

  private static int maxRobbery(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    if(null == nums || n ==0) {
      return 0;
    }
    if(n ==1) {
      return nums[0];
    }
    if(n == 2) {
      return Math.max(nums[0], nums[1]);
    }

    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for(int i = 2; i< n;i++) {
      dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
    }
    return dp[n-1];
  }
}
