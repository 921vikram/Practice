package math;

import java.util.ArrayList;

public class PrimeNumberAndFactors {

  public static void main(String[] args) {
    float rr = 1.0f;

    int n =100;
    int[] arr = new int[n];
    ArrayList<Integer> factors = new ArrayList();
    for(int i =0; i < n; i++) {
      arr[i] = i+1;
    }
    int sqrt = (int) Math.sqrt(n);
    boolean[] touched = new boolean[n];
    int[] ans = new int[n];
    int j = 0;
    // prime numbers will be always till root n max
    for(int i =2; i < Math.sqrt(n); i++) {

      if(!touched[i-1]) {
        ans[j] = i;
        j++;
        touched[i-1] = true;
      }

      for(int k = 2*i; k <=n; k = k+i) {
        touched[k-1] = true;
        while(arr[k-1] % i ==0) {
          factors.add(i);
          arr[k-1] = arr[k-1] / i;
        }
      }
    }

    for(int i =1; i < n; i++) {
      if(!touched[i]) {
        ans[j] = i+1;
        j++;
      }
    }

    for(int i =0 ; i< n; i++) {
      System.out.println(ans[i]);
    }

  }
}
