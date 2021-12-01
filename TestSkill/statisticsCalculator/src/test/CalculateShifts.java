package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CalculateShifts {

  /***
   *  8-9 9-11 14-17   output - 8-11, 14-17
   *  7-8 9-12  14-17
   *
   */

  private static class ShiftTiming {
    private Integer start;
    private Integer end;

    public Integer getStart() {
      return start;
    }

    public Integer getEnd() {
      return end;
    }

    public ShiftTiming(Integer start, Integer end) {
      this.start = start;
      this.end = end;
    }

  }

   public List<ShiftTiming> getContinuousShiftTiming(List<ShiftTiming> timings) {
     List<ShiftTiming> continuousShift = new ArrayList<>();

     PriorityQueue<ShiftTiming> pq = new PriorityQueue<ShiftTiming>(Comparator.comparing((s1) -> s1.getStart()));
     for (int i = 0; i < timings.size(); i++) {
       pq.add(timings.get(i));
     }

     ShiftTiming first = pq.poll();
     while (!pq.isEmpty()) {
       ShiftTiming current = pq.poll();
       if(first.getEnd() == current.getStart()) {

       } else {
         continuousShift.add(new ShiftTiming(first.getStart(), first.getEnd()));
       }
     }

      return continuousShift;
   }

   @Test
   public void testshift() {
     CalculateShifts calculateShifts = new CalculateShifts();

     List<ShiftTiming> shiftTimings = new ArrayList<>();
     shiftTimings.add(new ShiftTiming(9,11));
     shiftTimings.add(new ShiftTiming(7,9));
     shiftTimings.add(new ShiftTiming(13,17));

     List<ShiftTiming> output = calculateShifts.getContinuousShiftTiming(shiftTimings);

     Assert.assertEquals(output.size(), 2);

     Assert.assertEquals(java.util.Optional.ofNullable(output.get(0).getStart()), 7);
     Assert.assertEquals(java.util.Optional.ofNullable(output.get(0).getEnd()), 11);

     Assert.assertEquals(java.util.Optional.ofNullable(output.get(1).getStart()), 13);
     Assert.assertEquals(java.util.Optional.ofNullable(output.get(1).getEnd()), 17);
   }




}
