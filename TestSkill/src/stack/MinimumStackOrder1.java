package stack;

import java.util.Stack;

public class MinimumStackOrder1 {

  Stack<Integer> stack = new Stack<>();
  int min = -1;

  void push(int e) {
    if(stack.size() ==0) {
      min = e;
      stack.push(e);
    } else if(min > e){
      stack.push(2*e - min);
      min = e;
    } else {
      stack.push(e);
    }

  }

  int pop() {
    if(stack.size() == 0) {
      return -1;
    }
    if(stack.peek() < min) {
      min = 2*min - stack.peek();
    }
    return stack.pop();
  }

  int minimum() {
    if(stack.size() == 0) {
      return -1;
    }
    return min;
  }

  int top() {
    if(stack.size() == 0 ) {
      return -1;
    } else {
      if(stack.peek() < min) {
        return min;
      }
      return stack.peek();
    }
  }

  public static void main(String args[]) {

    int[] s = new int[]{18, 19, 29, 15, 16};
    MinimumStackOrder1 minimumStack = new MinimumStackOrder1();

    int i = 0;
    while (i < s.length) {
      minimumStack.push(s[i]);
      i++;
      System.out.println("Stack "+ minimumStack.min);
    }


  }


}
