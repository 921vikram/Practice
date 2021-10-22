package dp;

import java.util.Arrays;

public class EggDropingProblemMemoizationTopDown {

  public static int[][] t = new int[4][26];

  public static void main(String args[]) {
    Arrays.stream(t).forEach(a->Arrays.fill(a, -1));
    int f = 20;
    int e = 3;
    long t1 = System.nanoTime();
    int floor = solve(f, e);
    System.out.println("Time taken " + (System.nanoTime() - t1) / 1000);
    System.out.println("floor number " + floor);
  }


  private static int solve(int f, int e) {

    for(int i =0; i< f; i++) {
      t[1][i] = i;
      t[0][i] = Integer.MAX_VALUE;
    }

    for(int i =0; i< e; i++) {
      t[i][0] = 0;
      t[i][1] = 1;
    }

    int mn = Integer.MAX_VALUE;

    for(int i =2; i<=e; i++) {
      for(int j=2; j<=f; j++) {
        for(int  k =1; k< j;k++) {
          int tmp = 1 + Math.max(t[i-1][k-1], t[i][j-k]);
          mn = Math.min(tmp, mn);
          t[i][j] = mn;
        }
       }
    }
    return t[e][f];
  }


}
