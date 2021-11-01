package array;

/**
 * Find Maximum sum of the sub array size K
 * We can sum all the elements of sub array K and then move the window by removing the element from I and add from the J side
 */
public class MaximumSumSubArrayOfSizeK {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 5, 1, 8, 2, 9, 1};
    int k = 4;
    int i = 0;
    int maxSum = Integer.MIN_VALUE;
    int tmpSum = 0;
    for (int j = 0; j < arr.length; j++) {
      if (j - i < k) {
        tmpSum = tmpSum + arr[j];
      } else {
        tmpSum = tmpSum - arr[i] + arr[j];
        if (maxSum < tmpSum) {
          maxSum = tmpSum;
        }
        i++;
      }
    }
    System.out.println("maximum sum  " + maxSum);
  }
}
