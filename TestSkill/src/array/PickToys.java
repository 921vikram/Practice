package array;

import java.util.HashMap;

/**
 *
 */
public class PickToys {

  public static void main(String[] args) {
    char[] arr = new char[]{'a', 'b', 'c', 'd', 'a', 'b', 'c', 'b', 'b'};
    //char[] arr = new char[] {'p', 'w', 'w', 'k', 'e', 'w'};
    //char[] arr = new char[] {'a', 'u'};
    int i = 0;
    int k = 3;
    int maxLength = Integer.MIN_VALUE;
    HashMap<Character, Integer> mapCount = new HashMap<Character, Integer>();
    int j = 0;
    while (j < arr.length) {
      if (mapCount.get(arr[j]) == null) {
        mapCount.put(arr[j], 1);
      } else {
        mapCount.put(arr[j], mapCount.get(arr[j]) + 1);
      }

      if (mapCount.size() == k) {
        maxLength = Math.max(maxLength, j - i + 1);
      } else if (mapCount.size() > k) {
        while (mapCount.size() >  k) {
          if (mapCount.get(arr[i]) != null) {
            mapCount.put(arr[i], mapCount.get(arr[i]) - 1);
          }
          if (null != mapCount.get(arr[i]) && mapCount.get(arr[i]) == 0) {
            mapCount.remove(arr[i]);
          }
          i++;
        }
      }
      j++;
    }
    System.out.println("Maximum Toys selected of 3 types :  " + maxLength);
  }
}
