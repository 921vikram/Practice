package dp;

public class PalindromPartitioningMCM {


  public static void main(String args[]) {

    char[] X = {'n','i','t', 'i', 'n'};
    long t1 = System.currentTimeMillis();
    int cost = solve(X,1, X.length-1);
    System.out.println("Time taken " + (System.currentTimeMillis() - t1));
    System.out.println("Minimum Matrix multiplication cost  " + cost);
    //
  }

  private static int solve(char[] x, int i, int j) {
    if (i >= j) {
      return 0;
    }
    int mn = Integer.MAX_VALUE;
    for(int k=i; k<j;k++) {
      boolean isPalindrom1 = isPalindrom(x,i,k);
      boolean isPalindrom2 = isPalindrom(x,k+1,j);
      int tempAns = isPalindrom1 ? 1 : 0 ;
      if(tempAns < mn) {
        mn = tempAns;
      }
    }
    return mn;
  }

  private static boolean isPalindrom(char[] x, int i, int j) {
    if(j - i ==1) {
      return true;
    }
    for(int k = i; k< j/2; k++) {
      if(x[k] != x[j-k]) {
        return false;
      }
    }
    return true;
  }




}
