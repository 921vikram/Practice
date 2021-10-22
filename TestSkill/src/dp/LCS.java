package dp;

/**
 * Longest common sub sequence
 * start with comparing the last character first then if both matched we will add 1 + call the same method with n-1 and m-1
 * if not matched we have choice to choose either last of n or m so there will be 2 choices
 * tmp1 = LCS(x,y,n,m-1)
 * tmp2 = LCS(x,y,n-1,m)
 * return Math.max(tmp1,tmp2)
 *
 */
public class LCS {


  public static void main(String args[]) {
    char[]  X = {'a','b','c','d','g','h','a','b','c','d','g','h','a','b','g','h','a','b','t'};
    char[]  Y = {'a','b','e','d','f','h','a','b','e','d','f','h','a','g','h','a','b','c','n'};
    long t1 = System.currentTimeMillis();
    int res = LCS(X, Y, X.length, Y.length);
    System.out.println("Time taken "+(System.currentTimeMillis() - t1));
    System.out.println("LCS length  " + res);
  }

  public static int LCS(char[] X, char[] Y, int n, int m) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if(X[n-1] == Y[m-1]) {
      return 1+ LCS(X,Y,n-1, m-1);
    } else {
      int tmp1 = LCS(X, Y, n-1, m);
      int tmp2 = LCS(X, Y, n, m-1);
      return Math.max(tmp1, tmp2);
    }
  }

}
