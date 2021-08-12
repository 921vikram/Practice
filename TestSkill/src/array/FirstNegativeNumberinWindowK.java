package array;

import java.util.LinkedList;

public class FirstNegativeNumberinWindowK {

  public static void main(String[] args) {
    int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
    int i = 0;
    int k = 3;
    int l = 0;
    LinkedList<Integer> list = new LinkedList<Integer>();
    int[] ans = new int[arr.length - k + 1];
    for (int j = 0; j < arr.length; j++) {
      if (arr[j] < 0) {
        list.push(arr[j]);
      }
      if (j - i == k) {
        if (list.isEmpty()) {
          ans[l] = 0;
        } else {
          ans[l] = list.getLast();
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
