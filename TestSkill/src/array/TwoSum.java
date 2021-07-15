package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static void main(String args[]) {

    int[] s = new int[]{0, -1, 2, -3, 1};
    int sum = -4;
    Map<Integer, Boolean> map = new HashMap<>();
    int i=0;
    while (i<s.length) {
      if(map.get(sum  - s[i]) != null) {
        System.out.println(" pair "+s[i]+" "+(sum  - s[i]));
      }
      map.put(s[i], true);
      i++;
    }
  }
}
