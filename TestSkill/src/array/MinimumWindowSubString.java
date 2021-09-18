package array;

/**
 * Find the minimum window size where sum is 5
 * We can calculate sum till it's equal to 5. if sum is 5 then calculate the substring size and comapre with the old one and store the minimum
 *  if tmpsum is more then remove elements from i and  remove from the sum
 */
public class MinimumWindowSubString {

  public static void main(String[] args) {
    int[] arr = new int[] {4,1,1,2,1,1,2,3,5};
    int sum = 5;
    int i = 0;
    int minLength = Integer.MAX_VALUE;
    int tmpSum = 0;
    for(int j = 0 ; j < arr.length; j++) {
      tmpSum = tmpSum + arr[j];
      if(tmpSum == sum){
        minLength = Math.min(minLength, j -i+1);
        tmpSum = tmpSum - arr[i];
        i++;
      } else if(tmpSum > sum){
        while (tmpSum > sum) {
          tmpSum = tmpSum - arr[i];
          i++;
        }
      }
    }
    if(tmpSum == sum) {
      minLength = Math.min(minLength, arr.length - 1 -i +1);
    }

    System.out.println("Minimum Window of Sub String : "+minLength);
  }
}
