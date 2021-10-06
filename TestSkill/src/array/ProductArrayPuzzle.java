package array;

public class ProductArrayPuzzle {


  /* Driver program to test the above function */
  public static void main(String[] args)
  {
    int arr[] = { 10, 3, 5, 6, 2 };
    int n = arr.length;
    System.out.println("The product array is : ");
    productArray(arr, n);
  }

  private static void productArray(int[] arr, int n) {

    int[] products = new int[n];

    for(int i =0; i< n; i++) {
      products[i] = 1;
    }

    int tmp = 1;

    for(int i =0; i< n; i++) {
      products[i] = tmp;
      tmp = tmp * arr[i];
    }

    tmp =1;
    for(int i = n-1; i >=0; i--) {
      products[i] = products[i] * tmp;
      tmp = tmp * arr[i];
    }

    /* print the constructed prod array */
    for (int i = 0; i < n; i++)
      System.out.print(products[i] + " ");

    return;

  }


}
