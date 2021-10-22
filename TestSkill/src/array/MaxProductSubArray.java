package array;

/**
 * Maximum product sub array including negative numbers
 */
public class MaxProductSubArray {



  // Driver Code
  public static void main(String[] args)
  {
    int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
    System.out.println("Maximum Sub array product is " + maxSubArrayProduct(arr));
  }

  private static int maxSubArrayProduct(int[] arr) {
    int n = arr.length;
    int maxProduct = 1;
    int minProduct = 1;
    int maxSoFor = 1;
    int flag = 0;

    for(int i =0; i< n; i++) {

      if(arr[i] > 0) {
        maxProduct = maxProduct * arr[i];
        minProduct = Math.min(minProduct * arr[i], 1);
        flag = 1;
      } else if (arr[i] == 0) {
        minProduct = 1;
        maxProduct = 1;
      } else {
        int tmp = maxProduct;
        maxProduct = Math.max(minProduct * arr[i], 1);
        minProduct = tmp * arr[i];
      }

      if(maxSoFor < maxProduct) {
        maxSoFor = maxProduct;
      }

    }

    if (flag == 0 && maxSoFor == 0) {
      return 0;
    }

    return maxSoFor;
  }
}
