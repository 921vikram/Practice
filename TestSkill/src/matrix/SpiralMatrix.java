package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<Integer>();
    // Function Call
    print(ans, matrix, 0, 0, matrix.length, matrix[0].length);
    return ans;
  }

  private static void print(List<Integer> ans, int arr[][], int i, int j, int m, int n)
  {
    // If i or j lies outside the matrix
    if (i >= m || j >= n) {
      return;
    }

    // Print First Row
    for (int p = i; p < n; p++) {
      System.out.print(arr[i][p] + " ");
      ans.add(arr[i][p]);
    }

    // Print Last Column
    for (int p = i + 1; p < m; p++) {
      System.out.print(arr[p][n - 1] + " ");
      ans.add(arr[p][n - 1]);
    }

    // Print Last Row, if Last and
    // First Row are not same
    if ((m - 1) != i) {
      for (int p = n - 2; p >= j; p--) {
        System.out.print(arr[m - 1][p] + " ");
        ans.add(arr[m-1][p]);
      }
    }

    // Print First Column, if Last and
    // First Column are not same
    if ((n - 1) != j) {
      for (int p = m - 2; p > i; p--) {
        System.out.print(arr[p][j] + " ");
        ans.add(arr[p][j]);
      }
    }
    print(ans, arr, i + 1, j + 1, m - 1, n - 1);
  }


  /* Driver program to test above functions */
  public static void main(String[] args) {
    int N = 4;
    // Test Case 1
    int mat[][] = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    spiralOrder(mat);

  }
}
