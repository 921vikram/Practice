package dp;

import java.util.HashMap;
import java.util.Map;

public class EggDropingProblemRecursive {

  public static void main(String args[]) {

    int f = 20;
    int e = 3;
    long t1 = System.nanoTime();
    int floor = solve(f, e);
    System.out.println("Time taken " + (System.nanoTime() - t1) / 1000);
    System.out.println("floor number " + floor);
  }


  private static int solve(int f, int e) {
    if (e == 1) {
      return f;
    }
    if (f == 0 || f == 1) {
      return f;
    }
    int mn = Integer.MAX_VALUE;
    for (int i = 1; i <= f; i++) {
      int temp = 1 + Math.max(solve(i-1, e - 1), solve(f - i, e));
      mn = temp < mn ? temp : mn;
    }
    return mn;
  }


}
