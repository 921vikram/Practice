package string;

import java.util.Arrays;

public class RemoveDuplicateFromString {


  public static void main(String[] args) {
    String s = "vikrviakm";

    int counter = 0;
    int len = s.length();
    char[] arr = s.toCharArray();
    int length = 0;

    for(int i =0 ; i < len; i++) {
      int x = arr[i] - 'a';
      if((counter & (1 << x)) ==0 ) {
        counter = counter | (1 << x);
        arr[length] = (char)('a' + x);
        length++;
      }
    }

    System.out.println("String "+ new String(Arrays.copyOfRange(arr, 0, length)));

  }


}
