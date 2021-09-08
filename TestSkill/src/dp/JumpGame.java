package dp;

public class JumpGame {

  public static void main(String args[]) {
    int[] nums = new int[] {2,3,1,1,4};
    canJump(nums,0);
  }

  public static boolean canJump(int[] nums, int index) {
    if(nums.length == 0) {
      return false;
    }
    if (index == nums.length - 1) {
      return true;
    }
    int tmp = nums[index];
    if(index + tmp > nums.length) {
      return false;
    } else if (index + tmp < nums.length) {
      return canJump(nums, index + tmp);
    } else {
      return true;
    }

  }


}
