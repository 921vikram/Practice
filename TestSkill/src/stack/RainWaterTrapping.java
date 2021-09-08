package stack;

import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class RainWaterTrapping {

  public static void main(String args[]) {

    int[] s = new int[]{3, 0, 0, 2, 0,4};
    int max = -1;
    int[] MaxLeft = new int[s.length];
    int[] MaxRight = new int[s.length];
    // finD LEFT MAXIMUM FOR each index. if value at index is more than the max value then new value will be the maximum left value
    for(int i = 0; i < s.length; i++ ) {
      if(s[i] > max) {
        max = s[i];
      }
      MaxLeft[i] = max;
    }
    max = -1;
    // for right maximum start from right and save maximum value at each index
    for(int i = s.length-1; i >= 0; i-- ) {
      if(s[i] > max) {
        max = s[i];
      }
      MaxRight[i] = max;
    }

    int totalWater = 0;
    for(int i = 0; i < s.length; i++) {
      totalWater = totalWater +  (MaxLeft[i] > MaxRight[i] ? MaxRight[i] : MaxLeft[i]) - s[i] ;
    }

    System.out.println("Total Water Collected "+ totalWater);

  }


}
