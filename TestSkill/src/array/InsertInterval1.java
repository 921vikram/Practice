package array;

import stack.Pair;

import java.util.Arrays;
import java.util.Stack;

public class InsertInterval1 {

  public static int[][] insert(int[][] intervals, int[] newInterval) {
    int[][] output = new int[intervals.length][2];

    Stack<Pair<Integer, Integer>> stack = new Stack<Pair<Integer,Integer>>();
    stack.push(new Pair(intervals[0][0], intervals[0][1]));

    Pair<Integer, Integer> top = stack.peek();

    if(newInterval[0] <= top.second()) {
      stack.pop();

      int st = Math.min(top.first(), newInterval[0]);
      int en = Math.max(top.second(), newInterval[1]);

      stack.push(new Pair(st, en));
    } else {
      stack.push(new Pair(newInterval[0], newInterval[1]));
    }


    for (int i = 1; i < intervals.length; i++)
    {
      top = stack.peek();

      if (intervals[i][0] <= top.second()) {
        stack.pop();
        stack.push(new Pair(Math.min(top.first(), intervals[i][0]), Math.max(top.second(), intervals[i][1])));
      } else {
        stack.push(new Pair(intervals[i][0], intervals[i][1]));
      }
    }

    reverseStack(stack);

    int j =0;
    while(!stack.isEmpty()) {
      Pair<Integer,Integer> pair = stack.pop();
      output[j] = new int[] {pair.first(), pair.second()};
      j++;
    }

    return output;
  }

  public static void reverseStack(Stack<Pair<Integer, Integer>> stack) {
    if(!stack.isEmpty()) {
      Pair<Integer, Integer> tmp = stack.pop();
      reverseStack(stack);
      insert(stack, tmp);
    }
  }

  private static void insert(Stack<Pair<Integer,Integer>> s, Pair<Integer, Integer> elem) {
    if(s.size() == 0 ){
      s.push(elem);
      return;
    }
    Pair<Integer, Integer> temp = s.pop();
    insert(s, elem);
    s.push(temp);
  }


  public static void main(String[] args) {
    int[][] arrays = new int [][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
    int[] val = {4,8};
    int[][] output = insert(arrays, val);
    Arrays.stream(output).forEach(a -> System.out.println(a[0]+" "+a[1]));
  }


}
