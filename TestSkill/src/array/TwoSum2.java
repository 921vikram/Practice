package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
  public int[] twoSum(int[] nums, int target) {
    int index1 = 0;
    int index2 = 0;
    for(int i =0; i < nums.length; i++) {
      index1 = i;
      int diff = target - nums[i];
      for(int j=i+1; j< nums.length; j++) {
        if(diff == nums[j]) {
          index2 = j;
          break;
        }
      }
      if(index2 > 0) {
        break;
      }
    }
    return new int[]{index1, index2};
  }

  public static int[] twoSum1(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int i=0;
    while (i<nums.length) {
      if(map.get(target  - nums[i]) != null) {
        return new int[]{map.get(target  - nums[i]), i};
      }
      map.put(nums[i], i);
      i++;
    }
    return new int[]{-1,-1};
  }

  public static void main(String args[]) {

    int[] s = new int[]{0, -1, 2, -3, 1};
    int sum = -4;
    int[] out = twoSum1(s,sum);
    System.out.println("test "+out[0]+"  "+out[1]);
  }
}
