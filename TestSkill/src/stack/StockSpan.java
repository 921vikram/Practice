package stack;

import java.util.Stack;
import java.util.Vector;

public class StockSpan {

  public static void main(String args[]) {

    int[] s = new int[]{100, 80, 60, 70, 60, 75, 85};
    Stack<Pair<Integer,Integer>> stack = new Stack<>();
    Vector<Integer> v = new Vector<Integer>();

    for(int i = 0; i < s.length; i++ ) {

      if(stack.size() ==0) {
        v.add(-1);
      } else if (stack.size() > 0 && s[i] < stack.peek().first()) {
        v.add(stack.peek().second());
      } else if (stack.size() > 0 && s[i] > stack.peek().first()) {
        while (stack.size() >0 && s[i] >= stack.peek().first()) {
          stack.pop();
        }
        if(stack.size() ==0) {
          v.add(-1);
        } else {
          v.add(stack.peek().second());
        }
      }
      stack.push(new Pair(s[i], i));
    }

    int i = 0;
    while (i < v.size()) {
      System.out.println("elem " +(i- v.get(i)));
      i++;
    }
  }


}
