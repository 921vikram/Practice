package heap;

import stack.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

  public static void main(String args[]) {

    int[] s = new int[]{1, 1, 2, 3, 1 ,4, 2, 4, 3,1,3};

    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0; i< s.length; i++) {
      Integer value = map.get(s[i]);
      if (null == value) {
        map.put(s[i], 1);
      } else {
        map.put(s[i], value +1);
      }
    }


    int k = map.size();

    // Max heap
    PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue(new Comparator<Pair<Integer, Integer>> () {
      @Override
      public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return o2.first().compareTo(o1.first());
      }
    });

    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
      minHeap.add(new Pair<>(entry.getValue(), entry.getKey()));
      if(minHeap.size() > k) {
        minHeap.poll();
      }
    }

    while (minHeap.size() > 0 ) {
      int i =0;
      Pair<Integer, Integer> poll = minHeap.poll();
      while (i<poll.first()) {
        System.out.println("Frequency sort "+poll.second());
        i++;
      }
    }

  }



}
