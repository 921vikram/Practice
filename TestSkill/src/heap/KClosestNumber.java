package heap;

import stack.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestNumber {

  public static void main(String args[]) {

    int[] s = new int[]{1, 7, 2, 4, 8 ,5};
    int k =3;
    int x =7;
    ArrayList<Pair<Integer, Integer>> diff = new ArrayList<>();
    for(int i=0; i< s.length; i++) {
      diff.add(new Pair<>(Math.abs(s[i] -7), s[i]));
    }

    // Max heap
    PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue( new Comparator<Pair<Integer, Integer>> () {
      @Override
      public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return o2.first().compareTo(o1.first());
      }
    });

    for(int i = 0; i < diff.size(); i++ ) {
      maxHeap.add(diff.get(i));
      if(maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    while (maxHeap.size() > 0 ) {
      System.out.println("Closest numbers "+(maxHeap.poll().second()));
    }


  }


}
