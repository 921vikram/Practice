package array;

/**
 * Convert an Integer to binary number we can use bit operation based on if number is integer or Long
 * If integer is long then it will be 8 byte which is 8*8 = 64 bit
 * we can run loop from 63 to 0 and at bit at the position using right shift operator
 * we can and the bit with 1 if 1 comes that means bit at the ith position is 1 we can increase the count of 1
 */
public class IntegerToBinary {

  public static void main(String[] args) {
    long a = 11;
    long b = 19;

    for (long i = a; i <= b; i++) {
      int cnt = 0;
      for (int j = 63; j >= 0; j--) {
        long k = i >> j;
        if ((k & 1) > 0) {
          cnt++;
        }
      }
      if (cnt == 3) {
        System.out.println("Number " + i);
      }
    }
  }
}
