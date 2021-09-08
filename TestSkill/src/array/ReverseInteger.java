package array;

public class ReverseInteger {

  public static void main(String[] args) {
    int n=11;
    int rev = 0;
    int bits = 0;
    while (n > 0)
    {
      bits++;
      rev <<= 1;
      if ((int)(n & 1) == 1)
        rev ^= 1;
      n >>= 1;
    }

    System.out.println(rev);
  }
}
