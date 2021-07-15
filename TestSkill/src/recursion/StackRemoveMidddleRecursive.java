package recursion;

import java.util.Stack;

public class StackRemoveMidddleRecursive {
  public static void main(String args[]) {
    Stack<Integer> s = new Stack<>();
    s.add(1);
    s.add(2);
    s.add(3);
    s.add(4);
    s.add(5);
    s.add(6);
    int k = (s.size()/2)+1;
    getSort(s, k);
    int i=0;
    while(i<s.size()) {
      System.out.println("elem "+s.get(i));
      i++;
    }

  }

  private static void getSort(Stack<Integer> s, int k) {
    if(s.size() == 0) {
      return;
    }
    int last = s.pop();
    if(k==1) {
      return;
    }
    getSort(s, k-1);
    s.push(last);
    return;
  }


}
