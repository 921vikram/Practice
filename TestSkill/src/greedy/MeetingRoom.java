package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {



  public static void main(String[] args) {
    //int[][] meetings = new int[][] {{0,30}, {5,15}, {20,30}};
    int[][] meetings = new int[][] {{30,35}, {5,15}, {20,30}};


    if(null == meetings && meetings.length == 0) {
      System.out.println("Can attend meetings");
    }

    Arrays.sort(meetings, new Comparator<int[]> (){
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    int[] prev = meetings[0];

    for(int i = 1; i < meetings.length; i++) {
      int[] cur = meetings[i];

      if(prev[1] > cur[0]) {
        System.out.println("Can't attend meetings");
        System.exit(0);
      }
    }

    System.out.println("Can attend meetings");
  }
}
