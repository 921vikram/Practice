package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MergeInterval {

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

    Collections.sort(timings, (Comparator<ShiftTiming>) (o1, o2) -> o1.getStart() - o2.getStart());

    Stack<ShiftTiming> stack = new Stack<>();

    stack.push(timings.get(0));
    for(int i =1; i< timings.size(); i++) {
      ShiftTiming current = timings.get(i);
      ShiftTiming prev = stack.peek();

      if (prev.end < current.start) {
        stack.push(current);
      }

      else if (prev.end < current.end) {
        stack.pop();
        stack.push(new ShiftTiming(prev.getStart(), current.getEnd()));
      }

    }
    while(!stack.empty()) {
      continuousShift.add(stack.pop());
    }

    Collections.reverse(continuousShift);

    return continuousShift;
  }

  @Test
  public void testshift() {
    MergeInterval calculateShifts = new MergeInterval();

    List<ShiftTiming> shiftTimings = new ArrayList<>();
    shiftTimings.add(new ShiftTiming(9,11));
    shiftTimings.add(new ShiftTiming(7,9));
    shiftTimings.add(new ShiftTiming(13,17));

    List<ShiftTiming> output = calculateShifts.getContinuousShiftTiming(shiftTimings);

    Assert.assertEquals(2, output.size());

    Assert.assertEquals(7, output.get(0).getStart().intValue());
    Assert.assertEquals(11, output.get(0).getEnd().intValue());

    Assert.assertEquals(13, output.get(1).getStart().intValue());
    Assert.assertEquals(17, output.get(1).getEnd().intValue());
  }


}
