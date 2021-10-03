package binary_search;

/**
 * Bitonic array will be increasing sorted from start and increasing sorted from end
 *
 */
public class FindMaxInBitonicArray {

  public static void main(String args[]) {

    int[] s = new int[]{1, 2, 4, 7, 9, 12, 15, 14, 13, 10, 6, 3};
    int start = 0;
    int end = s.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      // Base condition as we are checking mid - 1 and mid + 1
      if (mid - 1 < 0 || (mid + 1 > s.length - 1)) {
        return;
      }
      //
      if (s[mid] > s[mid - 1] && s[mid] > s[mid + 1]) {
        System.out.println("Index " + mid);
        System.out.println("Value " + s[mid]);
        break;
      } else if (s[mid] < s[mid + 1]) {
        start = mid + 1;
      } else if (s[mid] < s[mid - 1]) {
        end = mid - 1;
      }
    }
  }
}
