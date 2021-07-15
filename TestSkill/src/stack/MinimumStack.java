package stack;

import java.util.Stack;
import java.util.Vector;

public class MinimumStack {

  Stack<Integer> stack = new Stack<>();
  Stack<Integer> supportStack = new Stack<>();

  void push(int e) {
    stack.push(e);
    if(supportStack.size() == 0 || supportStack.peek() >= e) {
      supportStack.push(e);
    }
  }

  int pop() {
    if(stack.size() == 0) {
      return -1;
    }
    int top = stack.peek();
    if(supportStack.peek() == top) {
      supportStack.pop();
    }
    stack.pop();
    return top;
  }

  int minimum() {
    if(supportStack.size() == 0) {
      return -1;
    }
    return supportStack.peek();
  }

  public static void main(String args[]) {

    int[] s = new int[]{18, 19, 29, 15, 16};
    MinimumStack minimumStack = new MinimumStack();

    int i = 0;
    while (i < s.length) {
      minimumStack.push(s[i]);
      i++;
      System.out.println("Stack "+ minimumStack.supportStack.peek());
    }


  }


}
