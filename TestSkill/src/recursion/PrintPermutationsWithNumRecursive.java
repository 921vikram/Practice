package recursion;

import java.util.Vector;

public class PrintPermutationsWithNumRecursive {

  public static void main(String args[]) {
    String op = "";
    int open = 3;
    int clsoe = 3;
    Vector<String> v = new Vector<String>();
    op = op + "(";
    open = open-1;
    solve(op, open, clsoe, v);
    for(String s : v) {
      System.out.println(s);
    }
  }

  private static void solve(String op, int open, int close, Vector<String> v) {
    if (open == 0 && close == 0) {
      v.add(op);
      return;
    }
    if (open != 0) {
      String op1 = op + "(";
      int t = open-1;
      solve(op1, t, close, v);
    }
    if (open < close) {
      int t1  = close-1;
      String op2 = op + ")";
      solve(op2, open, t1, v);
    }
    return;
  }

}