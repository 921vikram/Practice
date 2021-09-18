package array;

import java.util.HashMap;

/**
 * This class will find the occurrence of smaller string in the bigger string.
 * anagram of for  --> orf --> ofr --> fro --> rof --> rfo
 * Find all the anagram of for from  the array of characters
 */
public class CountOccurrenceOfAnagram {

  public static void main(String[] args) {
    char[] arr = new char[]{'f', 'o', 'r', 'x', 'x', 'o', 'r', 'f', 'x', 'd', 'o', 'f', 'r'};
    char[] ana = new char[]{'f', 'o', 'r'};
    int k = ana.length;
    int i = 0;
    int maxLength = 0;
    HashMap<Character, Integer> mapCount = new HashMap<Character, Integer>();
    // First capture count of all the characters of the anagram string  and put in the map
    for (char c : ana) {
      Integer count = mapCount.get(c);
      if (null == count) {
        mapCount.put(c, 1);
      } else {
        mapCount.put(c, count + 1);
      }
    }
    int tmpCount = mapCount.size();
    for (int j = 0; j < arr.length; j++) {
      Integer count = mapCount.get(arr[j]);
      // Go through the bigger string and reduce the count if character is found in the string
      if (null != count) {
        mapCount.put(arr[j], count - 1);
        if (mapCount.get(arr[j]) == 0) {
          // Reduce tmpCount as it will tell how many characters are still pending
          tmpCount--;
        }
      }
      // Once we reach the length of the smaller string we can fix the window as in case of anagram order of character can change but length will be same
      // once we reach the length we can move the window but increasing i and add the character in the map as j will remove.
      if (j - i + 1 == k) {
        // if tmpcount is 0 that means we have got all the characters of smaller string in bigger string consecutively so increase maxcount
        if (tmpCount == 0) {
          maxLength++;
        }
        Integer c = mapCount.get(arr[i]);
        if (null != c) {
          mapCount.put(arr[i], c + 1);
          // If count is 1 that means required character from smaller string is was at 0 and once we move i it increased to 1
          // We can increase the tmpCount.
          if (mapCount.get(arr[i]) == 1) {
            tmpCount++;
          }
        }
        i++;
      }
    }
    System.out.println("No. of Occurrences of Anagram String is : " + maxLength);
  }
}
