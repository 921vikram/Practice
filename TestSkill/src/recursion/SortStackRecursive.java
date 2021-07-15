package recursion;

import java.util.Stack;
import java.util.Vector;

public class SortStackRecursive {
  public static void main(String args[]) {
    Stack<Integer> s = new Stack<>();
    s.add(6);
    s.add(4);
    s.add(-2);
    s.add(9);
    s.add(-7);
    s.add(7);
    getSort(s);
    int i=0;
    while(i<s.size()) {
      System.out.println("elem "+s.get(i));
      i++;
    }

  }

  private static void getSort(Stack<Integer> s) {
    if(s.size() == 1) {
      return;
    }
    int last = s.pop();
    getSort(s);
    insert(s, last);
  }

  private static void insert(Stack<Integer> s, int last) {
    if(s.size() == 0 || s.peek() <= last) {
      s.add(last);
      return;
    }
    int temp = s.pop();
    insert(s, last);
    s.push(temp);
    return;
  }

}
