package dp;

public class EvaluateExpressionTrueMCM {


  public static void main(String args[]) {

    char[] X = {'T','|','F', '&', 'T','^','F'};
    long t1 = System.nanoTime();
    int ways = solve(X,0, X.length-1, true);
    System.out.println("Time taken " + (System.nanoTime() - t1)/1000);
    System.out.println("Number of ways to make it true  " + ways);
  }


  private static int solve(char[] x, int i, int j, boolean isTrue) {
    if (i > j) {
      return 0;
    }
    if(i ==j) {
      if(isTrue) {
        return x[i] == 'T' ? 1 : 0;
      } else {
        return x[i] == 'F' ? 1 : 0;
      }
    }
    int ans = 0;
    for(int k=i+1; k<j;k=k+2) {
      int lt = solve(x, i, k - 1, true);
      int lf = solve(x, i, k - 1, false);
      int rt = solve(x, k + 1, j, true);
      int rf = solve(x, k + 1, j, false);
      if (x[k] == '|') {
        if (isTrue) {
          ans = ans + lt*rt + lt*rf + lf*rt;
        } else {
          ans = ans + lf*rf;
        }
      } else if (x[k] == '&') {
        if (isTrue) {
          ans = ans + lt*rt;
        } else {
          ans = ans + lt*rf + lf*rf + lf*rf;
        }
      } else if (x[k] == '^') {
        if(isTrue) {
          ans = ans + lt*rf + rt*lf;
        } else {
          ans = ans + lt*rt + lf*rf;
        }
      }
    }
    return ans;
  }





}
