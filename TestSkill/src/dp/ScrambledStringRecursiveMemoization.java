package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Divide first string in 2  1st--- 0 to i  and second  n-i length
 * so for second string choose length of 0 to n-i for the first part and other part will be  n-i to n
 */
public class ScrambledStringRecursiveMemoization {


  public static Map<String, Boolean> map = new HashMap<>();

  public static void main(String args[]) {

    String a = "greatwryuqipbnrt";
    String b = "rgateqtmqioewqyh";
    long t1 = System.nanoTime();
    boolean ways = solve(a,b);
    System.out.println("Time taken " + (System.nanoTime() - t1)/1000);
    System.out.println("Both the Strings are scrambled " + ways);
  }


  private static boolean solve(String a, String b) {
    String key = a+"_"+b;
    if(null != map.get(key)) {
      return map.get(key);
    }
    if(a.length() != b.length()) {
      return false;
    }
    if(a.equals(b)) {
      return true;
    }
    int n= a.length();
    for(int i=1; i <a.length(); i++) {
      if((solve(a.substring(0, i), b.substring(n-i, n)) && solve(a.substring(i, n),b.substring(0, n-i)))
         || (solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i, n),b.substring(i, n)))) {
        map.put(key, true);
        return true;
      }
    }
    map.put(key, false);
    return false;
  }





}
