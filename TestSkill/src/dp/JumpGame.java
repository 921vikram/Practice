package dp;

import java.util.Arrays;

public class JumpGame {

  public static void main(String args[]) {
    int[] nums = new int[] {2,3,1,1,4};
    //int[] nums = new int[] {3,2,1,0,4};
    //int[] nums = new int[] {0};
    //int[] nums = new int[] {2, 0, 0};
    System.out.println("Minimum number of jumps : "+ canJump(nums));

  }

  public static int canJump(int[] nums) {
    int[] jumps = new int[nums.length];
    Arrays.fill(jumps, Integer.MAX_VALUE);
    jumps[0] = 0;
    for (int i =1; i<nums.length; i++) {
      for(int j =0 ; j < i; j++) {
        if(nums[j] >= i-j) {
          jumps[i] = Math.min(jumps[i], jumps[j] +1);
        }
      }
    }
    return jumps[nums.length -1];
  }


}
