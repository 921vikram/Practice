package array;

import java.util.HashMap;

public class LongestSubStrWithoutRepeatingChar {

  public static void main(String[] args) {
    //char[] arr = new char[] {'a', 'b', 'c', 'd', 'a', 'b', 'c', 'b', 'b'};
    //char[] arr = new char[] {'p', 'w', 'w', 'k', 'e', 'w'};
    char[] arr = new char[] {'a', 'u'};
    int i = 0;
    int maxLength = Integer.MIN_VALUE;
    int tmpLength = 0;
    HashMap<Character, Integer> mapCount  = new HashMap<Character, Integer>();
    for(int j = 0 ; j < arr.length; j ++) {
      if(null != mapCount.get(arr[j])) {
        maxLength = Math.max(maxLength, tmpLength);
        while(i<j) {
          if(arr[i] == arr[j]) {
            i++;
            break;
          }
          mapCount.remove(arr[i]);
          i++;
          tmpLength --;
        }
      } else {
        mapCount.put(arr[j],1);
        tmpLength++;
      }
    }
    if(tmpLength > maxLength) {
      maxLength = tmpLength;
    }
    System.out.println("maximum sum  "+maxLength);
  }
}
