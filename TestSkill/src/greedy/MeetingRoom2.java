package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {



  public static void main(String[] args) {
    int[][] meetings = new int[][] {{0,30}, {5,15}, {20,30}};
    //int[][] meetings = new int[][] {{30,35}, {5,15}, {20,30}};


    if(null == meetings && meetings.length == 0) {
      System.out.println("Can attend meetings");
    }

    Arrays.sort(meetings, new Comparator<int[]> (){
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1]-o2[1];
      }
    });

    pq.add(meetings[0]);
    int count = 0;
    for(int i = 1; i < meetings.length; i++) {
      int[] cur = meetings[i];
      int[] prev = pq.poll();
      if(prev[1] > cur[0]) {
        pq.add(cur);
        pq.add(prev);
      } else {
        pq.add(cur);
      }
    }

    System.out.println("Number of meeting rooms needed "+pq.size());
  }
}
