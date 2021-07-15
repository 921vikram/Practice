package recursion;

public class TowerOfhanoiRecursive {
  public static int i = 0;
  public static void main(String args[]) {
    int s =1 ;
    int h = 2;
    int d = 3;
    int n = 4;
    solve(s,d,h,n);
    System.out.println("Iteration "+i);
  }

  private static void solve(int s, int d, int h , int n) {
    i++;
    if(n ==1) {
      System.out.println("move plate "+n+" from "+s +" to "+d);
      return;
    }
    solve(s,h,d, n-1);
    System.out.println("move plate "+n+" from "+s +" to "+d);
    solve(h,d,s,n-1);
    return;
  }


}
