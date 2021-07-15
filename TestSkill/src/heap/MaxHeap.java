package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

public class MaxHeap {

  public static void main(String args[]) {

    int[] s = new int[]{1, 7, 2, 4, 8 ,5};
    int k =4;
    PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());

    for(int i = 0; i < s.length; i++ ) {
      maxHeap.add(s[i]);
      if(maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    System.out.println("3rd Minimum "+maxHeap.peek());
  }


}
