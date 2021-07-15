package binary.search;

public class NearlySortedBinarySearch {

  public static void main(String args[]) {

    int[] s = new int[]{1,2,4,5,7,12,9,15,19,20};
    int k = 9;
    int start = 0;
    int end = s.length-1;
    while (start < end) {
      int mid = start + (end-start)/2;

      if(s[mid] == k) {
        System.out.println("Index " + mid);
        break;
      } else if((mid -1) >=0 && s[mid-1] == k) {
        System.out.println("Index " + (mid-1));
        break;
      } else if ((mid +1) <s.length  && s[mid+1] == k) {
        System.out.println("Index " + (mid+1));
        break;
      } else if(s[mid] < k) {
        start = mid +1;
      } else {
        end = mid -1;
      }
    }
  }
}
