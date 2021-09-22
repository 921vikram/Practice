package array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestConsecutiveSequencePriorityQueue {

  private static int findLongestConsecutiveSubseq(int[] arr, int n) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      queue.add(arr[i]);
    }
    int maxCount = 1;
    int count = 1;
    int prev = queue.poll();
    while (!queue.isEmpty()) {
      int current = queue.peek();
      if(current == prev +1) {
        count++;
      } else if (current == prev) {
        // Do nothing go to next
      } else {
        maxCount = Math.max(maxCount, count);
        count = 1;
      }
      prev = queue.poll();
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
