package binary.search;

public class FindElemInInfiniteSortedArray {

  public static void main(String args[]) {

    int[] s = new int[]{1, 2, 4, 5, 7, 9, 12, 15, 19, 20, 31, 34, 45, 56, 57, 59, 62, 64, 65, 70, 71, 75, 77, 78, 80, 82, 84, 85, 87};
    int k = 20;
    int start = 0;
    int end = start + 1;
    while (start <= end) {
      if (k > s[end]) {
        start = end;
        end = end * 2;
        continue;
      }
      int mid = start+(end-start)/2;
      if (s[mid] == k) {
        System.out.println("Index " + mid);
        break;
      } else if (s[mid] < k) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
  }
}
