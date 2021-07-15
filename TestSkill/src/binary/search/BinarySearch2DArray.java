package binary.search;

public class BinarySearch2DArray {

  public static void main(String args[]) {

    int[][] s = new int[][]{{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
    int k = 39;
    int i = 0;
    int j = s[0].length - 1;
    while (i < s.length && j > 0) {
      if (s[i][j] == k) {
        System.out.println("i : " + i + " j : " + j);
        break;
      } else if (s[i][j] > k) {
        j--;
      } else if (s[i][j] < k) {
        i++;
      }
    }
  }
}
