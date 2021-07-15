package recursion;

import java.util.Vector;

public class JosephusRecursive {
  public static void main(String args[]) {
    Vector<Integer> s = new Vector<Integer>();
    s.add(1);
    s.add(2);
    s.add(3);
    s.add(4);
    s.add(5);
//    s.add(-7);
//    s.add(7);
    removeElement(s, 0, 3);
    int i=0;
    while(i<s.size()) {
      System.out.println("elem "+s.get(i));
      i++;
    }

  }

  private static void removeElement(Vector<Integer> s, int i, int k) {
    if(s.size() == 1) {
      return;
    }
    int n = s.size();
    i = (i+k-1) % n;
    s.removeElementAt(i);
    removeElement(s, i , k);
  }


}
