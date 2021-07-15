package heap;

import stack.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {

  public static void main(String args[]) {

    int[][] s = new int[][]{{1,3}, {-2,2}, {5,8}, {0,1}, {-1,1}};
    int k =2;
    ArrayList<Pair<Double, Integer>> diff = new ArrayList<>();
    for(int i=0; i< s.length; i++) {
      double distance = Math.sqrt(s[i][0]*s[i][0] + s[i][1]*s[i][1]);
      diff.add(new Pair<>(distance, i));
    }

    // Max heap
    PriorityQueue<Pair<Double, Integer>> maxHeap = new PriorityQueue( new Comparator<Pair<Double, Integer>> () {
      @Override
      public int compare(Pair<Double, Integer> o1, Pair<Double, Integer> o2) {
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
      Pair<Double, Integer> p = maxHeap.poll();
      System.out.println("Point "+(s[p.second()][0])+", "+(s[p.second()][1]));
    }


  }


}
