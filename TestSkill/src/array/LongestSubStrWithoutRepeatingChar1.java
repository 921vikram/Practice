package array;

import java.util.HashMap;

public class LongestSubStrWithoutRepeatingChar1 {

  public static void main(String[] args) {
    char[] arr = new char[] {'a', 'b', 'c', 'd', 'a', 'b', 'c', 'b', 'b'};
    //char[] arr = new char[] {'p', 'w', 'w', 'k', 'e', 'w'};
    //char[] arr = new char[] {'a', 'u'};
    int i = 0;
    int maxLength = Integer.MIN_VALUE;
    HashMap<Character, Integer> mapCount  = new HashMap<Character, Integer>();
    int j =0;
    while(j<arr.length) {
      if(mapCount.get(arr[j]) == null) {
        mapCount.put(arr[j], 1);
      } else {
        mapCount.put(arr[j], mapCount.get(arr[j]) + 1);
      }

      if(mapCount.size() == j-i +1) {
        maxLength = Math.max(maxLength, j-i+1);
      } else if(mapCount.size() < j - i + 1){
        while(mapCount.size() < j - i + 1) {
          if(mapCount.get(arr[i]) != null) {
            mapCount.put(arr[i], mapCount.get(arr[i]) -1);
          }
          if(null != mapCount.get(arr[i]) && mapCount.get(arr[i]) == 0) {
            mapCount.remove(arr[i]);
          }
          i++;
        }
      }
      j++;
    }
    System.out.println("maximum sum  "+maxLength);
  }
}
