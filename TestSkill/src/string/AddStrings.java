package string;

public class AddStrings {

  public static void main(String[] args) {
    String a = "1";
    String b = "9";
    int len1 = a.length()-1;
    int len2 = b.length()-1;
    String sumStr = "";
    int carry = 0;
    while(len1 >= 0 && len2 >=0) {
      Integer in1 = Integer.parseInt(a.substring(len1, len1+1));
      Integer in2 = Integer.parseInt(b.substring(len2, len2+1));
      int sum = in1 + in2 + carry;
      carry = sum/10;
      sumStr = sumStr+(sum%10);
      len1--;
      len2--;
    }
    //append rest of the number
    if(len1 >= 0) {
      while (len1 >= 0) {
        sumStr = sumStr + a.substring(len1, len1+1);
        len1--;
      }
    }
    if(len2 >= 0) {
      while (len2 >= 0) {
        sumStr = sumStr + b.substring(len2, len2+1);
        len2--;
      }
    }

    sumStr = new StringBuilder(sumStr).reverse().toString();
    System.out.println("Sum String "+sumStr);

  }

}
