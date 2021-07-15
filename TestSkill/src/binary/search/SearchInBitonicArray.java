package binary.search;

public class SearchInBitonicArray {

  public static void main(String args[]) {

    int[] s = new int[]{1,2,4,5,7,9,12,15,19,20,18,16,13,10,8,6,3};
    int k = 6;
    int peak = findPeek(s);
    int start = 0;
    int end = peak;
    while (start <= end) {
      int mid = start + (end-start)/2;
      if(s[mid] == k) {
        System.out.println("Index "+mid);
        System.out.println("value "+s[mid]);
        break;
      } else if(s[mid] < k) {
        start = mid +1;
      } else {
        end = mid -1;
      }
    }
    start=peak+1;
    end = s.length -1;
    while (start <= end) {
      int mid = start + (end-start)/2;
      if(s[mid] == k) {
        System.out.println("Index "+mid);
        System.out.println("value "+s[mid]);
        break;
      } else if(s[mid] < k) {
        end = mid -1;
      } else {
        start = mid +1;
      }
    }
  }

  private static int findPeek(int[] s) {
    int start = 0;
    int end = s.length-1;
    while (start <= end) {
      int mid = start + (end-start)/2;
      if(mid - 1 < 0 || (mid + 1 > s.length -1)) {
        return -1;
      }
      if(s[mid] > s[mid-1] && s[mid] > s[mid+1]) {
        System.out.println("Index "+mid);
        System.out.println("Value "+s[mid]);
        return mid;
      } else if(s[mid] < s[mid+1]) {
        start = mid +1;
      } else if(s[mid] < s[mid-1]){
        end = mid -1;
      }
    }
    return -1;
  }

}
