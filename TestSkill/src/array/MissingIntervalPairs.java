package array;

import stack.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * how many intervals will be dropped
 */
public class MissingIntervalPairs {
  public static void main(String args[]) {
    List<Pair<Integer, Integer>> pairs = new ArrayList<>();
    pairs.add(new Pair<>(1,3));
    pairs.add(new Pair<>(2,4));
    pairs.add(new Pair<>(3,5));
    pairs.add(new Pair<>(7,9));

    List<Pair<Integer, Integer>> missingInterval = new ArrayList<>();

    Collections.sort(pairs, new Comparator<Pair<Integer, Integer>>() {
      @Override
      public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return o1.first() - o2.first();
      }
    });
    int previousEnd = 0;
    for(Pair<Integer, Integer> pair : pairs) {
      if(pair.first() > previousEnd && previousEnd > 0) {
        missingInterval.add(new Pair<>(previousEnd, pair.first()));
      }
      previousEnd = pair.second();
    }
    missingInterval.stream().forEach(a-> System.out.println(a.first()+" "+a.second()));
  }
}
