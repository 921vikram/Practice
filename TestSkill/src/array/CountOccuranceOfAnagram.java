package array;

import java.util.HashMap;

public class CountOccuranceOfAnagram {

  public static void main(String[] args) {
    char[] arr = new char[]{'f', 'o', 'r', 'x', 'x', 'o', 'r', 'f', 'x', 'd', 'o', 'f', 'r'};
    char[] ana = new char[]{'f', 'o', 'r'};
    int k = ana.length;
    int i = 0;
    int maxLength = 0;
    HashMap<Character, Integer> mapCount = new HashMap<Character, Integer>();
    for (char c : ana) {
      Integer count = mapCount.get(c);
      if (null == count) {
        mapCount.put(c, 1);
      } else {
        mapCount.put(c, count + 1);
      }
    }
    int tmpCount = mapCount.size();
    for (int j = 0; j < arr.length; j++) {
      Integer count = mapCount.get(arr[j]);
      if (null != count) {
        mapCount.put(arr[j], count - 1);
        if (mapCount.get(arr[j]) == 0) {
          tmpCount--;
        }
      }
      if (j - i +1 == k) {
        if (tmpCount == 0) {
          maxLength++;
        }
        Integer c = mapCount.get(arr[i]);
        if (null != c) {
          mapCount.put(arr[i], c + 1);
          if (mapCount.get(arr[i]) == 1) {
            tmpCount++;
          }
        }
        i++;
      }
    }
    System.out.println("maximum sum  " + maxLength);
  }
}
