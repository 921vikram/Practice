package binary.search;

public class FirstElementInSortedArray {

  public static void main(String args[]) {

    int[] s = new int[]{1,2,4,5,7,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,12,15,19,20};
    int k = 10;
    int start = 0;
    int end = s.length-1;
    int fisrtOccurance = -1;
    while (start < end) {
      int mid = start + (end-start)/2;
      if(s[mid] == k) {
        System.out.println("Index "+mid);
        fisrtOccurance = mid;
        end = mid-1;
      } else if(s[mid] < k) {
        start = mid +1;
      } else {
        end = mid-1;
      }
    }
    System.out.println("First Occurrence : "+fisrtOccurance);

    start = 0;
    end = s.length-1;
    while (start < end) {
      int mid = start + (end-start)/2;
      if(s[mid] == k) {
        System.out.println("Index "+mid);
        fisrtOccurance = mid;
        start = mid+1;
      } else if(s[mid] < k) {
        start = mid +1;
      } else {
        end = mid-1;
      }
    }
    System.out.println("Last Occurrence : "+fisrtOccurance);

  }
}
