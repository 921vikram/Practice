package stack;

import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class MaximumAreaHistogram {

  public static void main(String args[]) {

    int[] s = new int[]{6, 2, 5, 4, 5,1,6};
    Stack<Pair<Integer, Integer>> stack = new Stack<>();
    Vector<Integer> v = new Vector<Integer>();

    for(int i = 0; i < s.length; i++ ) {
      if(stack.size() ==0) {
        v.add(-1);
      } else if (stack.size() > 0 && s[i] > stack.peek().first()) {
        v.add(stack.peek().second());
      } else if (stack.size() > 0 && s[i] <= stack.peek().first()) {
        while (stack.size() >0 && s[i] <= stack.peek().first()) {
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

    stack = new Stack<>();
    Vector<Integer> v1 = new Vector<Integer>();
    for(int i=s.length-1;i>=0;i--) {
      if(stack.size() ==0) {
        v1.add(s.length);
      } else if (stack.size() >0 && s[i] > stack.peek().first()) {
        v1.add(stack.peek().second());
      } else if (stack.size() >0 && s[i] <= stack.peek().first()) {
        while (stack.size() >0 && s[i] <= stack.peek().first()) {
            stack.pop();
        }
        if(stack.size() == 0) {
          v1.add(s.length);
        } else {
          v1.add(stack.peek().second());
        }
      }
      stack.push(new Pair(s[i], i));
    }
    Collections.reverse(v1);

    int i = 0;
    while (i < v.size()) {
      System.out.println("elem " + v.get(i));
      i++;
    }
    i = 0;
    while (i < v1.size()) {
      System.out.println("elem v1 " + v1.get(i));
      i++;
    }
    i = 0;
    int max = 0;
    while (i < s.length) {
      int area = s[i]*(v1.get(i) - v.get(i) -1);
      if(max < area) {
        max = area;
      }
      i++;
    }
      System.out.println("Area " +max );
  }


}
