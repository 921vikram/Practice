package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestSumBetweenKs {

  public static void main(String args[]) {

    int[] s = new int[]{1,3,12,5,15,11, 20};
    int k1 = 3;
    int k2 = 6;
    // Max heap
    PriorityQueue<Integer> minHeap = new PriorityQueue(Comparator.reverseOrder());

    for(int i = 0; i < s.length; i++ ) {
      minHeap.add(s[i]);
      if(minHeap.size() >= k2) {
        minHeap.poll();
      }
    }

    int totalCost = 0;
    while (minHeap.size() > k1) {
      totalCost = totalCost + minHeap.poll();
    }
    System.out.println("Total Cost "+totalCost);
  }
}
