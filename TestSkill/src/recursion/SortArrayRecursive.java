package recursion;

import java.util.*;

public class SortArrayRecursive {
  public static void main(String args[]) {
    Vector<Integer> s = new Vector<Integer>();
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

  private static void getSort(Vector<Integer> s) {
    if(s.size() == 1) {
      return;
    }
    int last = s.lastElement();
    s.removeElementAt(s.size() -1);
    getSort(s);
    insert(s, last);
  }

  private static void insert(Vector<Integer> s, int last) {
    if(s.size() == 0 || s.get(s.size() -1) <= last) {
      s.add(last);
      return;
    }
    int temp = s.lastElement();
    s.removeElementAt(s.size() -1);
    insert(s, last);
    s.add(temp);
    return;
  }

}
