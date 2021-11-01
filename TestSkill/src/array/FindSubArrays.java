package array;

import java.util.Scanner;

public class FindSubArrays {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int len = sc.nextInt();
    int[] arr = new int[len];
    for(int i =0; i < len; i++) {
      arr[i] = sc.nextInt();
    }
    int total = 0;

    for(int i =0; i < len; i++) {
      for(int j=i; j<=len; j++) {
        int tmpTotal = 0;
        for(int k=i; k<j; k++ ) {
          tmpTotal += arr[k];
          //System.out.print(arr[k] + " ");
        }
        if(tmpTotal < 0) {
          total++;
        }
        //System.out.println();
      }
    }
    System.out.println(total);
  }
}
