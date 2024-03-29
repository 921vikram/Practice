package dp;

public class PalindromPartitioningMCM {


  public static void main(String args[]) {

    char[] X = {'n','i','t', 'i', 'm'};
    long t1 = System.currentTimeMillis();
    int cost = solve(X,0, X.length-1);
    System.out.println("Time taken " + (System.currentTimeMillis() - t1));
    System.out.println("Minimum Partitioning cost  " + cost);
    //
  }

  private static int solve(char[] x, int i, int j) {
    if (i >= j) {
      return 0;
    }
    if(isPalindrom(x,i,j)) {
      return 0;
    }
    int mn = Integer.MAX_VALUE;
    for(int k=i; k<j;k++) {
      int tempAns = 1 + solve(x,i,k) + solve(x,k+1,j);
      if(tempAns < mn) {
        mn = tempAns;
      }
    }
    return mn;
  }

  private static boolean isPalindrom(char[] x, int i, int j) {
    while (i<j) {
      if(x[i] != x[j]) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }




}
