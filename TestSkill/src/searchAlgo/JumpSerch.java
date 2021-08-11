package searchAlgo;

public class JumpSerch {

  public static void main(String args[]) {

    int[] s = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
    int n = s.length;
    int k = 1;
    int m = (int) Math.sqrt(n);
    for(int i = m; i<n; i=i+m) {
      if(s[i] == k) {
        System.out.println("index "+i);
        break;
      } else if (s[i] > k) {
        for(int j = i-1; j>i-m; j--) {
          if(s[j] == k) {
            System.out.println("index " + j);
            break;
          }
        }
      }
    }

  }
}
