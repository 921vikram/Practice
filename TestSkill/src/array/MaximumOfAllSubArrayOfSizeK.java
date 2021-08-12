package array;

import java.util.LinkedList;

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
      // OR if list in not empty
      if (list.isEmpty() || list.getFirst() < arr[j]) {
        list.push(arr[j]);
      }
      if (j - i + 1 == k) {
        if (list.isEmpty()) {
          ans[l] = 0;
        } else {
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
