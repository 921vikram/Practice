package array;

import stack.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingInterval {
  public static void main(String args[]) {
    List<Pair<Integer, Integer>> pairs = new ArrayList<>();
    pairs.add(new Pair<>(1,2));
    pairs.add(new Pair<>(1,2));
    pairs.add(new Pair<>(1,2));

    Collections.sort(pairs, new Comparator<Pair<Integer, Integer>>() {
      @Override
      public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return o1.first() - o2.first();
      }
    });
    int drop = 0;
    int currentEnd = 0;
    for(Pair<Integer, Integer> pair : pairs) {
      if(pair.first() > currentEnd) {
        currentEnd = pair.second();
      } else if (pair.first() < currentEnd) {
        drop++;
      }
    }

    System.out.println("Drop : "+drop);
  }
}
