package recursion;

public class ClimbingStairs {

  private static int[] result;

  public static int climbStairs(int n) {
    if (result[n] != 0) {
      return result[n];
    }
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    }
    return result[n] = climbStairs(n - 1) + climbStairs(n - 2);
  }

  public static void main(String[] args) {
    result = new int[5];
    climbStairs(4);
    System.out.println("ways " + result[4]);
  }

}
