package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ConnectRopeToMinCost {

  public static void main(String args[]) {

    int[] s = new int[]{1,2,3,4,5};
    // Min heap
    PriorityQueue<Integer> minHeap = new PriorityQueue(Comparator.naturalOrder());

    for(int i = 0; i < s.length; i++ ) {
      minHeap.add(s[i]);
    }

    int totalCost = 0;
    while (minHeap.size() > 1) {
      int first = minHeap.poll();
      int second = minHeap.poll();
      int tmpCost = first+second;
      totalCost = totalCost + tmpCost;
      minHeap.add(tmpCost);
    }
    System.out.println("Total Cost "+totalCost);
  }
}
