package array;

import java.util.ArrayList;
import java.util.List;

/**
 * If Word found in dictionary
 */
public class WordBreak {

  public static List<String> wordDict = new ArrayList();
  public static void main(String[] args) {
    wordDict.add("mobile");
    wordDict.add("samsung");
    wordDict.add("sam");
    wordDict.add("sung");
    wordDict.add("man");

    //wordDict.add("leet");
    //wordDict.add("code");
    //String s = "leetcode";
    String s = "catsandog";

    if(wordBreak(s)) {
      System.out.println("Word Found");
    }

  }


  public static boolean wordBreak(String word) {
    int size = word.length();
    if(size ==0) {
      return true;
    }
    for(int i = 1; i < size; i++) {
      String sub = word.substring(0,i);
      if(wordDict.contains(sub) && wordBreak(word.substring(i, size))) {
        return true;
      }
    }
    return false;
  }


}
