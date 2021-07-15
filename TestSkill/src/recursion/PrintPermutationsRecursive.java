package recursion;

public class PrintPermutationsRecursive {

  public static void main(String args[]) {
    String ip = "abc";
    String op = ip.substring(0,1);
    ip = ip.substring(1);
    solve(ip,op);
  }

  private static void solve(String ip, String op) {
    if(ip.length() == 0) {
      System.out.println(op);
      return;
    }
    String op1 = op+ip.charAt(0);
    String op2 = op+"_"+ip.charAt(0);
    ip = ip.substring(1);
    solve(ip, op1);
    solve(ip, op2);
    return;
  }

}