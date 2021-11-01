package matrix;

public class TransformMatrix {


  static void transform(int mat[][]) {
    int m = mat.length;
    int n = mat[0].length;

    int [][] res = new int[m][n];

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(i == 0 && j ==0) {
          res[i][j] = mat[i][j];
        } else if (i ==0) {
          res[i][j] = mat[i][j] + res[i][j-1];
        } else if (j ==0) {
          res[i][j] = mat[i][j] + res[i-1][j];
        } else {
          res[i][j] = mat[i][j] + res[i-1][j] + res[i][j-1] - res[i-1][j-1];
        }
      }
    }

    displayMatrix(res);
  }

  // Function to print the matrix
  static void displayMatrix(int mat[][]) {
    int N = mat.length;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.print(" " + mat[i][j]);
      System.out.print("\n");
    }
    System.out.print("\n");
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
    displayMatrix(mat);
    transform(mat);
    // Print rotated matrix
    displayMatrix(mat);
  }

}
