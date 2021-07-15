package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeapKthSoterdArray {

  public static void main(String args[]) {

    int[] s = new int[]{6, 5, 3, 2, 8 ,10, 9};
    int[] sorted = new int[s.length];
    int k =3;
    PriorityQueue<Integer> minHeap = new PriorityQueue(Comparator.naturalOrder());

    for(int i = 0; i < s.length; i++ ) {
      minHeap.add(s[i]);
      if(minHeap.size() > k) {
        sorted[i-k] = minHeap.poll();
      }
    }
    int i = s.length - k;
    while (minHeap.size() > 0) {
      sorted[i] = minHeap.poll();
      i++;
    }

    i=0;
    while (i < sorted.length) {
      System.out.println("3rd Minimum "+sorted[i]);
      i++;
    }
  }


}
