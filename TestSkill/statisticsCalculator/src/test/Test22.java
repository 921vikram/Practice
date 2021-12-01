package test;


import java.util.*;

/**
 * Find two non-overlapping pairs having equal sum in an Array
 * Input : {1,4,5,0,1,2}
 *
 *     Output : {1,4}, {5,0}
 *     Output : {1,5}, {4,2}
 * Output : {1,1},{2,0}
 *
 * Invalid output : {1,4}, {4,1}
 */
public class Test22 {

  private static class Pair<T> {
    public T first;
    public T second;

    public Integer firstIndex;
    public Integer secondIndex;

    public Pair(T f, T s, Integer firstIndex, Integer secondIndex) {
      this.first = f;
      this.second = s;
      this.firstIndex = firstIndex;
      this.secondIndex = secondIndex;
    }

    @Override
    public String toString() {
      return "Pair{" +
        "first=" + first +
        ", second=" + second +
        '}';
    }
  }


public static void main(String args[]) {
  int[] arr = new int[] {1,4,5,0,1,2};
  // 0 and 1
  // 1 and 4
  Map<Integer, List<Pair>> map = new HashMap<>();
  Set<String> keys = new HashSet<>();

  for(int i =0; i < arr.length; i++) {
    for(int j=i; j< arr.length; j++) {
      Pair newPair = new Pair(arr[i], arr[j], i, j);
      Integer key = arr[i]+arr[j];
      if(keys.add(arr[i]+"_"+arr[j])) {
      List<Pair> pairList = map.get(key);
      if(null == pairList) {
        pairList = new ArrayList<>();
      } else {
        Set<Integer> indexes = new HashSet<>();
        for(Pair pair : pairList) {
          indexes.add(pair.firstIndex);
          indexes.add(pair.secondIndex);
        }
        if(indexes.contains(i) || indexes.contains(j)) {
          continue;
        }
      }
      pairList.add(newPair);
      map.put(key, pairList);
      }
    }
  }

  for(Integer key : map.keySet()) {
    System.out.println("Sum "+key);
    List<Pair> values = map.get(key);
    for(Pair p : values) {
      System.out.println(p.toString());
    }
  }


}


}
