package binary_search;

public class CountOccurInSortedArray {

  public static void main(String args[]) {

    int[] s = new int[]{1, 2, 4, 5, 7, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 15, 19, 20};
    int k = 10;
    int start = 0;
    int end = s.length - 1;
    int fisrtOccurrence = -1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (s[mid] == k) {
        fisrtOccurrence = mid;
        // for first occurrence we need to set end as mid -1 so that we can traverse back and get the first element
        end = mid - 1;
      } else if (s[mid] < k) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    System.out.println("First Occurrence index : " + fisrtOccurrence);


    int lastOccurrence = -1;
    start = 0;
    end = s.length - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (s[mid] == k) {
        lastOccurrence = mid;
        // set start as mid + 1 so that we can reach to the last occurrence of the given number
        start = mid + 1;
      } else if (s[mid] < k) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    System.out.println("Last Occurrence index : " + lastOccurrence);

    System.out.println("Number of occurrence : " + (lastOccurrence - fisrtOccurrence + 1));
  }
}
