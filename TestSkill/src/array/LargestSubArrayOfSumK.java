package array;

/**
 * Find the largest sub array from the given array so that sum of numbers will match to given SUM
 * We will have variable window size start wil i = 0 and j runs from 0 to n
 * we will calculate tmpSum by increasing j --> if tmpSum matches the given sum we will have our ans. (j -i +1) size of the window
 * we will compare with the older ans if length is bigger we can update the latest lenght
 * <p>
 * if tempSum is more we will move i till the time tmpSum will come less than the given sum
 */
public class LargestSubArrayOfSumK {

  public static void main(String[] args) {
    int[] arr = new int[]{4, 1, 1, 2, 1, 1, 2, 3, 5};
    int sum = 5;
    int i = 0;
    int maxLength = Integer.MIN_VALUE;
    int tmpSum = 0;
    for (int j = 0; j < arr.length; j++) {
      tmpSum = tmpSum + arr[j];
      if (tmpSum == sum) {
        maxLength = Math.max(maxLength, j - i + 1);
        tmpSum = tmpSum - arr[i];
        i++;
      } else if (tmpSum > sum) {
        while (tmpSum > sum) {
          tmpSum = tmpSum - arr[i];
          i++;
        }
      }
    }
    System.out.println("Largest Sub Array Size  " + maxLength);
  }
}
