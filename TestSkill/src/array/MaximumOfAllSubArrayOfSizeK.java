package array;

import java.util.LinkedList;

/**
 * Find the maximum number from each window and return
 * Ex-   1 3 -1 -3 5 3 6 7
 * window size 3
 * 1  3 -1    max-  3
 * 3 -1 -3          3
 * -1 -3 5          5
 * -3 5 3           5
 * 5 3 6            6
 * 3 6 7            7
 */
public class MaximumOfAllSubArrayOfSizeK {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;

    int i = 0;
    int l = 0;
    LinkedList<Integer> list = new LinkedList<Integer>();
    int[] ans = new int[arr.length - k + 1];
    for (int j = 0; j < arr.length; j++) {
      // If list is empty then we need to push the first element
      // OR if list in not empty then only bigger number than the first element will be added in the queue
      if (list.isEmpty() || list.getFirst() < arr[j]) {
        list.push(arr[j]);
      }
      if (j - i + 1 == k) {
        if (list.isEmpty()) {
          ans[l] = 0;
        } else {
          // Get the first number from the list which was put in the list as this number will be bigger then previous number
          ans[l] = list.getFirst();
        }
        l++;
        if (!list.isEmpty() && arr[i] == list.getLast()) {
          list.removeLast();
        }
        i++;
      }
    }
    for (int an : ans) {
      System.out.println(an);
    }
  }
}
