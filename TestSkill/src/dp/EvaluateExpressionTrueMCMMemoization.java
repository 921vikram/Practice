package dp;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionTrueMCMMemoization {

  private static Map<String, Integer> map = new HashMap<>();

  public static void main(String args[]) {
    char[] X = {'T', '|', 'F', '&', 'T', '^', 'F'};
    long t1 = System.nanoTime();
    int ways = solve(X, 0, X.length - 1, true);
    System.out.println("Time taken " + (System.nanoTime() - t1) / 1000);
    System.out.println("Number of ways to make it true  " + ways);
    //
  }


  private static int solve(char[] x, int i, int j, boolean isTrue) {
    String key = i + "_" + j + "_" + isTrue;
    if (map.get(key) != null) {
      return map.get(key);
    }
    if (i > j) {
      return 0;
    }
    if (i == j) {
      if (isTrue) {
        return x[i] == 'T' ? 1 : 0;
      } else {
        return x[i] == 'F' ? 1 : 0;
      }
    }
    int ans = 0;
    for (int k = i + 1; k < j; k = k + 2) {
      String key1 = i + "_" + (k - 1) + "_" + true;
      int lt = -1;
      if (null != map.get(key1)) {
        lt = map.get(key1);
      } else {
        lt = solve(x, i, k - 1, true);
      }
      int lf = -1;
      key1 = i + "_" + (k - 1) + "_" + false;
      if (null != map.get(key1)) {
        lf = map.get(key1);
      } else {
        lf = solve(x, i, k - 1, false);
      }
      int rt = -1;
      key1 = (k+1)+ "_" + j + "_" + true;
      if (null != map.get(key1)) {
        rt = map.get(key1);
      } else {
        rt = solve(x, k + 1, j, true);
      }

      int rf = -1;
      key1 = (k+1) + "_" + j + "_" + false;
      if (null != map.get(key1)) {
        rf = map.get(key1);
      } else {
        rf = solve(x, k + 1, j, false);
      }

      if (x[k] == '|') {
        if (isTrue) {
          ans = ans + lt * rt + lt * rf + lf * rt;
        } else {
          ans = ans + lf * rf;
        }
      } else if (x[k] == '&') {
        if (isTrue) {
          ans = ans + lt * rt;
        } else {
          ans = ans + lt * rf + lf * rf + lf * rf;
        }
      } else if (x[k] == '^') {
        if (isTrue) {
          ans = ans + lt * rf + rt * lf;
        } else {
          ans = ans + lt * rt + lf * rf;
        }
      }
    }
    map.put(key, ans);
    return ans;
  }


}
