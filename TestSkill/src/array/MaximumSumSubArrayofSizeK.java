package array;

public class MaximumSumSubArrayofSizeK {

  public static void main(String[] args) {
    int[] arr = new int[] {2, 5, 1, 8, 2, 9, 1};
    int k = 4;
    int i = 0;
    int maxSum = Integer.MIN_VALUE;
    int tmpSum = 0;
    for(int j = 0 ; j < arr.length; j ++) {
      if(j - i < k) {
        tmpSum = tmpSum + arr[j];
      } else {
        tmpSum = tmpSum - arr[i] + arr[j];
        if(maxSum < tmpSum) {
          maxSum = tmpSum;
        }
        i++;
      }
    }
    System.out.println("maximum sum  "+maxSum);
  }
}
