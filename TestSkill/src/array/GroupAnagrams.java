package array;

import java.util.*;

public class GroupAnagrams {
  private static class Word {
    String str;
    int index;

    public Word(String s, int i) {
      this.str = s;
      this.index = i;
    }

    private static class DuplicateArray {
      int n;
      Word[] arr;

      public DuplicateArray(String[] array, int size) {
        this.n = size;
        arr = new Word[size];
        for (int i = 0; i < array.length; i++) {
          arr[i] = new Word(array[i], i);
        }
      }
    }

    private static void printGroupOfAnagram(String[] array, int size) {
      DuplicateArray duplicateArray = new DuplicateArray(array, size);

      for (int i = 0; i < duplicateArray.n; i++) {
        char[] charArrray = duplicateArray.arr[i].str.toCharArray();
        Arrays.sort(charArrray);
        duplicateArray.arr[i].str = new String(charArrray);
      }

      Arrays.sort(duplicateArray.arr, new Comparator<Word>() {
        @Override
        public int compare(Word o1, Word o2) {
          return o1.str.compareTo(o2.str);
        }
      });

      List<List<String>> output = new ArrayList<>();
      String word = duplicateArray.arr[0].str;
      List<String> strs = new ArrayList<>();
      for (int i = 0; i < array.length; i++) {
        if(word.equals(duplicateArray.arr[i].str)) {
          strs.add(array[duplicateArray.arr[i].index]);
        } else {
          word = duplicateArray.arr[i].str;
          output.add(strs);
          strs = new ArrayList<>();
          strs.add(array[duplicateArray.arr[i].index]);
        }
        System.out.println(" " + array[duplicateArray.arr[i].index]);
      }
      output.add(strs);
      System.out.println();
    }

    // Driver program to test above functions
    public static void main(String args[]) {
      String wordArr[] = {"cat", "dog", "tac", "god", "act"};
      int size = wordArr.length;
      printGroupOfAnagram(wordArr, size);
      System.out.println();
    }

  }
}
