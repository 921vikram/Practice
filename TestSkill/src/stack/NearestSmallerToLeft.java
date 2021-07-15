package stack;

import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class NearestSmallerToLeft {

  public static void main(String args[]) {

    int[] s = new int[]{0, 3, 1, 2, 9};
    Stack<Integer> stack = new Stack<>();
    Vector<Integer> v = new Vector<Integer>();

    for(int i = 0; i < s.length; i++ ) {
      if(stack.size() ==0) {
        v.add(-1);
      } else if (stack.size() > 0 && s[i] > stack.peek()) {
        v.add(stack.peek());
      } else if (stack.size() > 0 && s[i] <= stack.peek()) {
        while (stack.size() >0 && s[i] <= stack.peek()) {
          stack.pop();
        }
        if(stack.size() ==0) {
          v.add(-1);
        } else {
          v.add(stack.peek());
        }
      }
      stack.push(s[i]);
    }

    int i = 0;
    while (i < v.size()) {
      System.out.println("elem " + v.get(i));
      i++;
    }
  }


}
