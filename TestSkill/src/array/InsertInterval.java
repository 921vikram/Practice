package array;

import java.util.Arrays;

public class InsertInterval {

  public static int[][] insert(int[][] intervals, int[] newInterval) {

    int[][] output = new int[intervals.length][intervals[0].length];
    int j =0;

    int end = -1;
    int newStart = newInterval[0];
    int newEnd = newInterval[1];

    for(int i = 0; i < intervals.length; i++) {
      if(end > intervals[i][0]) {
        continue;
      }
      if(newStart >= intervals[i][0] && newStart <= intervals[i][1]) {
        end = Math.max(newEnd, intervals[i][1]);
        output[j] = new int[]{Math.min(newStart, intervals[i][0]), end};
      } else if(newStart > intervals[i][1]){
        output[j] = intervals[i];
      } else if (end < intervals[i][1] && intervals[i][0] <= end) {
        end = output[j-1][1] = intervals[i][1];
      } else {
        output[j] = intervals[i];
      }
      j++;
    }
    return output;
  }

  public static void main(String[] args) {
    int[][] arrays = new int [][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
    int[] val = {4,8};
    int[][] output = insert(arrays, val);
    Arrays.stream(output).forEach(a -> System.out.println(a[0]+" "+a[1]));
  }


}
