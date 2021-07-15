package binary.search;

public class FindOneInInfiniteSortedArray {

  public static void main(String args[]) {

    int[] s = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    int start = 0;
    int end = start + 1;
    int ans = -1;
    while (start <= end) {
      if (1 > s[end]) {
        start = end;
        end = end * 2;
        continue;
      }
      int mid = start+(end-start)/2;
      if (s[mid] == 1) {
        end = mid -1;
        ans = mid;
        System.out.println("Index " + mid);
      } else if (s[mid] < 1) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    System.out.println("Ans "+ans);
  }
}
