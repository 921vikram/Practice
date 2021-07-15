package recursion;

import java.util.Vector;

public class NbitBinaryNumRecursive {

  public static void main(String args[]) {
    String op = "";
    int ones = 0;
    int zeros = 0;
    Vector<String> v = new Vector<String>();
    int n = 3;
    solve(op, ones, zeros, n, v);
    for (String s : v) {
      System.out.println(s);
    }
  }

  private static void solve(String op, int ones, int zeros, int n, Vector<String> v) {
    if (n == 0) {
      v.add(op);
      return;
    }
    String op2 = op + "1";
    solve(op2, ones + 1, zeros, n - 1, v);
    if (ones > zeros) {
      String op1 = op + "0";
      solve(op1, ones, zeros + 1, n - 1, v);
    }
    return;
  }

}