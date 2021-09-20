package array;

import java.util.Arrays;

public class UniversityCareerFair {

  public static int numOfMaxEvents(int[] arr, int[]dur) {
    int drop = 0;
    int NumOfEvents = arr.length;
    int [][] intervals = new int[NumOfEvents][2];

    for (int i = 0; i < NumOfEvents; i++) {
      intervals[i] = new int[] {arr[i], arr[i] + dur[i]};
    }

    Arrays.sort(intervals, (a, b) ->(a[1] - b[1]));
    // the finish time of first event;
    int curTime = intervals[0][1];

    for (int i = 1; i < NumOfEvents; i++) {
      int [] toSchedual = intervals[i];
      // toSchedule 0 is start time if currTime which is end time is more than start time of next event then drop it.
      if (toSchedual[0] < curTime)
        drop++;
      else {
        // toScheduler 1 is end time
        curTime = toSchedual[1];
      }
    }
    return NumOfEvents - drop;


  }

  public static void main(String[] args) {
    int[] arrival1 = {1,3,3,5,7};
    int[] duration1 = {2,2,1,2,1};
    System.out.println(numOfMaxEvents(arrival1, duration1));
    int[] arrival2 = {1,3,3,5,7, 6, 9};
    int[] duration2 = {2,2,1,2,1, 10, 2};
    System.out.println(numOfMaxEvents(arrival2, duration2));
    int[] arrival = {1,3,35,7};
    int[] duration = {2,2,1,2,1};
    System.out.println(numOfMaxEvents(arrival, duration));
  }
}
