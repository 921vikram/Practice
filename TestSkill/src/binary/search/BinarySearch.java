package binary.search;

public class BinarySearch {

  public static void main(String args[]) {

    int[] s = new int[]{10,20,30,40};
    int k = 2;
    if(s.length < k) {
      System.out.println("Invalid input");
    }
    int arraySum = 0;
    int i = 0;
    while(i<s.length) {
      arraySum = arraySum + s[i];
      i++;
    }
    int start = 0;
    int end = arraySum-1;
    while (start <= end) {
      int mid = start + (end-start)/2;
      if(isValid(s, mid, k)) {
        end = mid -1;
      } else {
        start = mid +1;
      }
    }
  }

  private static boolean isValid(int[] s, int mid, int k) {
    int tmpStudents = 1;
    int sum = 0;
    for(int i=0; i< s.length; i++) {
      sum = sum + s[i];
      if(sum > mid) {
        sum = s[i];
        tmpStudents++;
      }
    }
    if(tmpStudents == k) {
      return true;
    }
    return false;
  }
}
