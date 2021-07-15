package stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class MaximumAreaRectangle {

  public static void main(String args[]) {

    int[][] s = new int[][]{{0,1,1,0}, {1,1,1,1}, {1,1,1,1}, {1,1,0,0}};
    int[] s1 = new int[4];
    Arrays.fill(s1, -1);
    int max = -1;
    for(int i=0; i<s.length; i++) {
      for(int j =0; j< s[0].length; j++) {
        if(-1 == s1[j]) {
          s1[j] =  s[i][j];
        } else if (s[i][j] == 0){
          s1[j]= 0;
        } else {
          s1[j] =  s[i][j]+ s1[j];
        }
      }
      for(int m=0;m<s1.length;m++) {
        System.out.println(" elemenets s1 "+s1[m]);
      }
      Vector<Integer> v = new Vector<Integer>();
      int tmp = getMax(s1, v);
      System.out.println("tmp "+tmp);
      if(max < tmp) {
        max = tmp;
      }
    }

    System.out.println("Area " +max );
  }

  private static int getMax(int[] s, Vector<Integer> v) {
    Stack<Pair<Integer, Integer>> stack = new Stack<>();
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
    for(int i = s.length-1; i>=0; i--) {
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
    return max;
  }


}
