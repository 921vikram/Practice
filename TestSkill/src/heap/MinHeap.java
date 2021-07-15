package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeap {

  public static void main(String args[]) {

    int[] s = new int[]{1, 7, 2, 4, 8 ,5};
    int k =3;
    PriorityQueue<Integer> minHeap = new PriorityQueue(Comparator.naturalOrder());

    for(int i = 0; i < s.length; i++ ) {
      minHeap.add(s[i]);
      if(minHeap.size() > k) {
        minHeap.poll();
      }
    }
    System.out.println("3rd Minimum "+minHeap.peek());
  }


}
