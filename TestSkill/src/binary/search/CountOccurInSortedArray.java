package binary.search;

public class CountOccurInSortedArray {

  public static void main(String args[]) {

    int[] s = new int[]{1,2,4,5,7,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,12,15,19,20};
    int k = 10;
    int start = 0;
    int end = s.length-1;
    int fisrtOccurance = -1;
    while (start < end) {
      int mid = start + (end-start)/2;
      if(s[mid] == k) {
        fisrtOccurance = mid;
        end = mid-1;
      } else if(s[mid] < k) {
        start = mid +1;
      } else {
        end = mid-1;
      }
    }
    System.out.println("First Occurrence : "+fisrtOccurance);

    int last = -1;
    start = 0;
    end = s.length-1;
    while (start < end) {
      int mid = start + (end-start)/2;
      if(s[mid] == k) {
        last = mid;
        start = mid+1;
      } else if(s[mid] < k) {
        start = mid +1;
      } else {
        end = mid-1;
      }
    }
    System.out.println("Last Occurrence : "+last);

    System.out.println("Number of occurrence : "+(last-fisrtOccurance+1));
  }
}
