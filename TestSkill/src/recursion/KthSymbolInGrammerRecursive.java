package recursion;

import java.util.Stack;

public class KthSymbolInGrammerRecursive {
  public static void main(String args[]) {
    System.out.println(reverseStack(3,5));
  }

  private static boolean reverseStack(int n, int k) {
    if(n ==1 && k==1) {
      return false;
    }
    double mid = Math.pow(2, n-2);
    if(k <= mid) {
      return reverseStack(n-1, k);
    } else {
      return !reverseStack(n-1, k-(int)mid);
    }
  }


}
