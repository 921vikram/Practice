package array;

public class SetMatrixZones {


  void setZones(int a[][])
  {
    int rows = a.length;
    int cols = a[0].length;
    boolean[] rowsWithZeros = new boolean [rows];
    boolean[] colsWithZeros =  new boolean[cols];

    for(int i =0; i < rows; i++) {
      for(int j=0; j < cols; j++) {
        if(a[i][j] == 0) {
          rowsWithZeros[i] = true;
          colsWithZeros[j] = true;
        }
      }
    }

    for(int i =0; i < rows; i++) {
      for(int j=0; j < cols; j++) {
        if(rowsWithZeros[i] || colsWithZeros[j]) {
          a[i][j] = 0;
        }
        System.out.print(" " +a[i][j]);
      }
      System.out.println("");
    }


  }

  public static void main(String args[])
  {
    SetMatrixZones stock = new SetMatrixZones();

    int a[][] = { { 1, 2, 3, 4 },
      { 5, 6, 0, 8 },
      { 9, 10, 11, 12 },
      { 13, 0, 15, 16 } };

    // function call
    stock.setZones(a);

  }
}
