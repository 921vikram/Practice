package array;

public class SentencePalindrome {

  private static boolean sentencePalindrome(String str) {
    if(null == str) {
      return false;
    }
    str = str.toLowerCase().trim();
    int l = 0;
    int h = str.length()  -1;

    while(l<h) {
      char s = str.charAt(l);
      char e = str.charAt(h);

      if(!(s >= 'a' && s <= 'z')) {
        l++;
      } else if(!(e >= 'a' && e <= 'z')) {
        h--;
      } else if(s == e) {
        l++;
        h--;
      } else {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args)
  {
    //String str = "Too hot to hoot.";
    //String str = "Race a car";
    String str = "0P";
    if( sentencePalindrome(str))
      System.out.println("Sentence is palindrome");
    else
      System.out.println("Sentence is not" + " " +
        "palindrome");
  }

}
