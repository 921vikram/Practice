package binary_search;

public class FloorElemInBinarySearch {

  public static void main(String args[]) {

    int[] s = new int[]{1, 2, 4, 5, 7, 9, 12, 15, 19, 20};
    int k = 33;
    int start = 0;
    int ans = -1;
    int end = s.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (s[mid] == k) {
        System.out.println("Index " + mid);
        break;
      } else if (s[mid] < k) {
        ans = s[mid];
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    System.out.println("Floor " + ans);
  }
}
