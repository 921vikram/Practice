package heap;

import stack.Pair;

import java.util.*;

public class KFrequentNumber {

  public static void main(String args[]) {

    int[] s = new int[]{1, 1, 2, 3, 1 ,4, 2, 4, 3,1,3};
    int k =2;

    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0; i< s.length; i++) {
      Integer value = map.get(s[i]);
      if (null == value) {
        map.put(s[i], 1);
      } else {
        map.put(s[i], value +1);
      }
    }

    // Min heap
    PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue(new Comparator<Pair<Integer, Integer>> () {
      @Override
      public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return o1.first().compareTo(o2.first());
      }
    });

    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
      maxHeap.add(new Pair<>(entry.getValue(), entry.getKey()));
      if(maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    while (maxHeap.size() > 0 ) {
      System.out.println("Frequent numbers "+(maxHeap.poll().second()));
    }


  }


}
