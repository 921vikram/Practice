package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Return 1 if pair for 2 integers are found.
 * There are 2 problems if non repeating character then we can use Set to hold the sum of 2 integers if we found any other sum we can return 1
 * <p>
 * Other case --> If repeating characters are present. In that case we will store the numbers are also in the map so that value will be combinations
 * of 2 number if same combination is found we will not return 1 will check some other pair where value is different that means both the numbers will
 * be different but sum will be same
 */
public class FindPairs {

  public static void main(String[] args) {
    int[] arr = new int[]{4, 1, 1, 2, 1, 1, 2, 3, 5};
    int t = findPairs(arr);
    System.out.println("Find pairs  " + t);
  }

  public static int findPairs(int arr[]) {
    HashMap<Integer, String> pair = new HashMap<>();
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        Integer pai = arr[i] + arr[j];
        String value = arr[i] + "_" + arr[j];
        if (null != pair.get(pai) && !pair.get(pai).equals(value)) {
          return 1;
        }
        pair.put(pai, value);
      }
    }
    return 0;
  }

  public static int findPairsWithHashSet(int arr[]) {
    Set<Integer> pair = new HashSet<>();
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        Integer pai = arr[i] + arr[j];
        if (pair.contains(pai)) {
          return 1;
        }
        pair.add(pai);
      }
    }
    return 0;
  }

}
