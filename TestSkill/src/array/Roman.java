package array;

import java.util.HashMap;
import java.util.Map;

public class Roman {
  static Map<Character, Integer> map = new HashMap<Character, Integer>();


  public static void main(String args[]) {
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    System.out.println(romanToInt("DCXXI"));
  }

  public static int romanToInt(String s) {
    int i =0;
    int j = 0;
    int sum = 0;
    while (j < s.length()) {
      if((j-i+1) == 2) {
        if(map.get(s.charAt(i))  < map.get(s.charAt(j))) {
          int temp = map.get(s.charAt(j)) - (2 *map.get(s.charAt(i)));
          sum = sum + temp;
        } else {
          sum = sum + map.get(s.charAt(j));
        }
        i++;
      } else {
        sum = sum + map.get(s.charAt(j));
      }
      j++;
    }
    return sum;
  }
}
