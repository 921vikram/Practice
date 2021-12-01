package array;

import java.util.Scanner;

/**
 * Print all the sub-arrays of a given lenght array
 * first parameter is lenght of integer array
 * 3 noo of elements then number of elements  1,2,3
 */

public class FindSubArrays {
  public static void main(String[] args) {
    //Scanner sc = new Scanner(System.in);
    int len = 3;//sc.nextInt();
    int[] arr = new int[len];
    arr[0] = 3;
    arr[1] = 4;
    arr[2] = 1;
//    for(int i =0; i < len; i++) {
//      arr[i] = Math.random(10);//sc.nextInt();
//    }
    int total = 0;

    for(int i =0; i < len; i++) {
      for(int j=i; j<=len; j++) {
        int tmpTotal = 0;
        for(int k=i; k<j; k++ ) {
          tmpTotal += arr[k];
          System.out.print(arr[k] + " ");
        }
        if(tmpTotal < 0) {
          total++;
        }
        System.out.println();
      }
    }
    System.out.println(total);
  }
}
