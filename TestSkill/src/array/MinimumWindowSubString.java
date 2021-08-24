package array;

public class MinimumWindowSubString {

  public static void main(String[] args) {
    int[] arr = new int[] {4,1,1,2,1,1,2,3,5};
    int sum = 5;
    int i = 0;
    int maxLength = Integer.MIN_VALUE;
    int tmpSum = 0;
    for(int j = 0 ; j < arr.length; j++) {
      tmpSum = tmpSum + arr[j];
      if(tmpSum == sum){
        maxLength = Math.max(maxLength, j -i+1);
        tmpSum = tmpSum - arr[i];
        i++;
      } else if(tmpSum > sum){
        while (tmpSum > sum) {
          tmpSum = tmpSum - arr[i];
          i++;
        }
      }
    }
    System.out.println("maximum sum  "+maxLength);
  }
}
