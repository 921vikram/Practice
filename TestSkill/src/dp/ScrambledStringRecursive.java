package dp;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStringRecursive {


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
    if(a.length() != b.length()) {
      return false;
    }
    if(a.equals(b)) {
      return true;
    }
    int n= a.length();
    /**
     * There are 2 choices if
     */
    for(int i=1; i <a.length(); i++) {
      if((solve(a.substring(0, i), b.substring(n-i, n)) && solve(a.substring(i, n),b.substring(0, n-i)))
         || (solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i, n),b.substring(i, n)))) {
        return true;
      }
    }
    return false;
  }





}
