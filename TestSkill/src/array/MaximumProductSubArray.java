package array;

public class MaximumProductSubArray {

  public static void main(String[] args) {
    //int[] arr = new int[]{-2, 0, -1};
    int[] arr = new int[]{2, 3, -2, 4};
    int maxProduct = Integer.MIN_VALUE;
    int tmpProduct = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) {
        tmpProduct = Integer.MIN_VALUE;
      } else {
        if(tmpProduct == Integer.MIN_VALUE) {
          tmpProduct = arr[i];
        } else {
          tmpProduct *= arr[i];
        }
      }
      maxProduct = Math.max(maxProduct, tmpProduct);
    }

    System.out.println("Products : " + maxProduct);

  }


}
