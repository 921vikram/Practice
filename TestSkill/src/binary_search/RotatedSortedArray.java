package binary_search;

/**
 * for calculating previous we need to divide my length  of the of the string
 * pre = (mid -1 + length) % length
 * pre = (mid + 1 + length) % length
 */
public class RotatedSortedArray {

  public static void main(String args[]) {

    int[] s = new int[]{7,9,12,15,19,20,1,2,3,4,5};
    int start = 0;
    int end = s.length-1;
    while (start < end) {
      int mid = start + (end-start)/2;
      int prev = (mid -1 + s.length)%s.length;
      int next = (mid + 1 + s.length)%s.length;
      if(s[mid] <= s[next] && s[mid] <= s[prev]) {
        System.out.println("Index "+mid);
        break;
      } else if(s[mid] <= s[end]) {
        end = mid -1;
      } else if(s[start] <= s[mid]){
        start = mid + 1;
      }
    }
  }
}
