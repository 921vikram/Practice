package array;

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
      if(cnt ==3) {
        System.out.println("Number "+i);
      }
    }
  }
}
