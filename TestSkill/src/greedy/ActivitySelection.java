package greedy;

public class ActivitySelection {


  public static void main(String args[]) {
    int s[] =  {1, 3, 0, 5, 8, 5};
    int f[] =  {2, 4, 6, 7, 9, 9};
    int n = s.length;
    long t1 = System.currentTimeMillis();
    System.out.println("First selection "+s[0]+" , "+f[0]);
    int j = 0;
    for(int i = 1; i< n-1; i++) {

      if(s[i] > f[j]) {
        System.out.println("selection "+s[i]+" , "+f[j]);
        j=i;
      }
    }
  }


}
