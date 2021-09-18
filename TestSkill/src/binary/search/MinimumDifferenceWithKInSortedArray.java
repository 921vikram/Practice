package binary.search;

/**
 * Fist Search for an element in the array and
 * if element not found then start and end will be near to the searched element
 */
public class MinimumDifferenceWithKInSortedArray {

  public static void main(String args[]) {

    int[] s = new int[]{1, 2, 3, 4, 5, 7, 9, 12, 15, 19, 20};
    int k = 18;
    int start = 0;
    int end = s.length - 1;
    int ans = -1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (s[mid] == k) {
        System.out.println("Index " + mid);
        ans = mid;
        break;
      } else if (s[mid] > k) {
        end = mid - 1;
      } else if (s[mid] < k) {
        start = mid + 1;
      }
    }
    if (ans == -1) {
      // if start is reached till last element then nearest element will be the last element
      if (start >= s.length) {
        System.out.println("Minimum diff " + s[s.length - 1]);
        // if end is reached till 0th position then nearest element will be first element
      } else if (end < 0) {
        System.out.println("Minimum diff " + s[0]);
      } else {
        // if it's middle of the array then we can find the diff from the K and print the element with minimum diff
        if ((s[start] - k) < (k - s[end])) {
          System.out.println("Minimum difference " + s[start]);
        } else {
          System.out.println("Minimum difference " + s[end]);
        }

      }
    }
  }
}
