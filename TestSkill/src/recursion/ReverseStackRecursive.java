package recursion;

import java.util.Stack;

public class ReverseStackRecursive {
  public static void main(String args[]) {
    Stack<Integer> s = new Stack<>();
    s.add(6);
    s.add(4);
    s.add(-2);
    s.add(9);
    s.add(-7);
    s.add(7);
    int i=0;
    while(i<s.size()) {
      System.out.println("elem "+s.get(i));
      i++;
    }
    reverseStack(s);
    System.out.println("reverse");
    i=0;
    while(i<s.size()) {
      System.out.println("elem "+s.get(i));
      i++;
    }

  }

  private static void reverseStack(Stack<Integer> s) {
    if(s.size() == 1) {
      return;
    }
    int last = s.pop();
    reverseStack(s);
    insert(s, last);
    return;
  }

  private static void insert(Stack<Integer> s, int elem) {
    if(s.size() == 0 ){
      s.push(elem);
      return;
    }
    int temp = s.pop();
    insert(s, elem);
    s.push(temp);
  }

}
