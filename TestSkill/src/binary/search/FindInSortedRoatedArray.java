package binary.search;

import java.util.Arrays;

public class FindInSortedRoatedArray {

  public static void main(String args[]) {

    int[] s = new int[]{7,9,12,15,19,20,1,2,3,4,5};
    int k =2;
    int min = findMinimumIndex(s);
    int[] s1 = Arrays.copyOfRange(s, 0, min-1);
    int[] s2 = Arrays.copyOfRange(s, min, s.length -1);
    int ans1 = binarySearch(s1,k);
    int ans2 = binarySearch(s2, k);
    if(ans1 != -1) {
      System.out.println("Ans1 "+ ans1);
    }
    if(ans2 != -1) {
      System.out.println("Ans2 "+ (ans2+min));
    }
  }

  public static int binarySearch(int[] s, int k) {
    int start = 0;
    int end = s.length-1;
    while (start < end) {
      int mid = start + (end-start)/2;
      if(s[mid] == k) {
        System.out.println("Index "+mid);
        return mid;
      } else if(s[mid] < k) {
        start = mid +1;
      } else {
        end = mid -1;
      }
    }
    return -1;
  }

  private static int findMinimumIndex(int[] s) {
    int start = 0;
    int end = s.length-1;
    while (start < end) {
      int mid = start + (end-start)/2;
      int prev = (mid -1 + s.length)%s.length;
      int next = (mid + 1 + s.length)%s.length;
      if(s[mid] <= s[next] && s[mid] <= s[prev]) {
        System.out.println("Minimum  "+mid);
        return  mid;
      } else if(s[mid] <= s[end]) {
        end = mid -1;
      } else if(s[start] <= s[mid]){
        start = mid + 1;
      }
    }
    return -1;
  }



}
