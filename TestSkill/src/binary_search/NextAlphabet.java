package binary_search;

public class NextAlphabet {

  public static void main(String args[]) {

    char[] s = new char[]{'a','b', 'd', 'f', 'g', 'h'};
    char ch = 'a';
    int start = 0;
    int end = s.length-1;
    char res = '#';
    while (start <= end) {
      int mid = start + (end-start)/2;
      if(s[mid] == ch) {
        System.out.println("Index "+mid);
        start = mid+1;
      } else if(s[mid] < ch) {
        start = mid +1;
      } else {
        res = s[mid];
        end = mid -1;
      }
    }
    System.out.println("res "+ res);
  }
}
