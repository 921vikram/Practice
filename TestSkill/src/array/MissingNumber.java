package array;

public class MissingNumber {

  public static int missingNumber(int[] nums) {
    int a = nums[0];
    int b = 1;
    for (int i = 1; i < nums.length; i++) {
      a = a ^ nums[i];
    }

    for (int i = 2; i <= nums.length; i++) {
      b = b ^ i;
    }
    return (a ^ b);
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 0, 1, 3, 4, 6, 5, 8, 7, 10};
    System.out.println("Missing number " + missingNumber(nums));
  }
}
