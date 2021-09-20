package string;

public class LongestRepeatingCharReplacement {
  public static void main(String args[]) {
    String s = "ABAB";
    int k = 2;
    int res = 0;
    int startWindow = 0;
    int maxFrequency = 0;
    int[] charactersCount = new int[26];
    for (int endWindow = 0; endWindow < s.length(); endWindow++) {
      char c = s.charAt(endWindow);
      charactersCount[c - 'A']++;
      maxFrequency = Math.max(maxFrequency, charactersCount[c - 'A']);
      while (endWindow - startWindow + 1 - maxFrequency > k) {
        startWindow++;
        charactersCount[c - 'A']--;
      }
      res = Math.max(res, endWindow - startWindow + 1);
    }
    System.out.println("Longest repeating character lenght : " + res);

  }

}
