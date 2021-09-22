package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

  private static int findLongestConsecutiveSubseq(int[] arr, int n) {
    Set elements = new HashSet();
    for (int i = 0; i < n; i++) {
      elements.add(arr[i]);
    }

    int maxCount = 0;
    for (int i = 0; i < n; i++) {
      if (!elements.contains(arr[i] - 1)) {
        int j = arr[i];
        while (elements.contains(j)) {
          j++;
        }
        if(maxCount < j - arr[i]) {
          maxCount = j - arr[i];
        }
      }
    }
    return maxCount;
  }

  // Driver Code
  public static void main(String args[]) {
    int arr[] = {1, 9, 3, 10, 4, 20, 2};
    int n = arr.length;
    System.out.println(
      "Length of the Longest consecutive subsequence is "
        + findLongestConsecutiveSubseq(arr, n));
  }
}
