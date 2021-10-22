package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity 2^n
 * Back Tracking
 */
public class WordBreakWithAns {

  public static List<String> wordDict = new ArrayList();
  public static void main(String[] args) {
    wordDict.add("mobile");
    wordDict.add("samsung");
    wordDict.add("sam");
    wordDict.add("sung");
    wordDict.add("man");
    wordDict.add("cat");
    wordDict.add("cats");
    wordDict.add("and");
    wordDict.add("sand");
    wordDict.add("dog");


    //wordDict.add("leet");
    //wordDict.add("code");
    //String s = "leetcode";
    String s = "catsanddog";

    String ans = "";
    wordBreak(s.length(), s, ans);
    System.out.println("Answer "+ans);


  }


  public static void wordBreak(int n, String word, String ans) {

    for(int i = 1; i <= n; i++) {
      String sub = word.substring(0,i);
      if(wordDict.contains(sub)) {

        if(i == n) {
          ans += sub;
          System.out.println(ans);
          return;
        }
        wordBreak(n-i, word.substring(i, n), ans+sub+" ");
      }
    }
  }


}
