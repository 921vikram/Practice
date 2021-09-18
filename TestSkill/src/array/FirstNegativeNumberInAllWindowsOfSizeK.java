package array;

import java.util.LinkedList;

/**
 * Find first negative number in all the windows from the given array
 * ex-  12 -1 -7 8 -15 30 16 28
 * window size 3
 * then   12 -1 -7  window first negative number will be -1
 * -1 -7  8   -1
 * -7 8 -15    -7
 * 8 -15 30    -15
 * -15 30 16   -15
 * 30 16 28    0
 * So Ans will be  -1 , -1,  -7, -15, -15, 0
 */
public class FirstNegativeNumberInAllWindowsOfSizeK {

  public static void main(String[] args) {
    int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
    int i = 0;
    int k = 3;
    int l = 0;
    // to hold all the negative number in the given window.
    // This will be updated once we move the window and remove the number if we are moving to next number
    LinkedList<Integer> list = new LinkedList<Integer>();
    // Answer length will be array length  - window size + 1
    int[] ans = new int[arr.length - k + 1];
    for (int j = 0; j < arr.length; j++) {
      // If negative number put in the list
      if (arr[j] < 0) {
        list.push(arr[j]);
      }
      // If window size if reached
      if (j - i == k) {
        // If list if empty that means no negative number in linked list ans will be 0 for that window
        if (list.isEmpty()) {
          ans[l] = 0;
        } else {
          // get the last one from the list this linked list will behave like queue
          ans[l] = list.getLast();
        }
        l++;
        // remove the last one from queue if it matches with the character at i as we are increasing the i
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
