package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindPairs {

  public static void main(String[] args) {
    int[] arr = new int[] {4,1,1,2,1,1,2,3,5};
    int t = findPairs(arr);
    System.out.println("Find pairs  "+t);
  }

  public static int findPairs(int arr[])
  {
    HashMap<Integer, String> pair = new HashMap<>();
    for(int i=0; i<arr.length-1; i++) {
      for(int j=i+1; j < arr.length; j++) {
        Integer pai = arr[i]+arr[j];
        String value = arr[i]+"_"+arr[j];
        if(null != pair.get(pai) && !pair.get(pai).equals(value)) {
          return 1;
        }
        pair.put(pai, value);
      }
    }
    return 0;
  }

  public static int findPairsWithHashSet(int arr[])
  {
    Set<Integer> pair = new HashSet<>();
    for(int i=0; i<arr.length-1; i++) {
      for(int j=i+1; j < arr.length; j++) {
        Integer pai = arr[i]+arr[j];
        if(pair.contains(pai)) {
          return 1;
        }
        pair.add(pai);
      }
    }
    return 0;
  }

}
