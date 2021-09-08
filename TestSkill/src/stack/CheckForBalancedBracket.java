package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckForBalancedBracket {

  public static void main(String[] args) {
    String expr = "([{}])";

    // Function call
    if (areBracketsBalanced(expr))
      System.out.println("Balanced ");
    else
      System.out.println("Not Balanced ");
  }

  private static boolean areBracketsBalanced(String expr) {
    Deque<Character> deque = new ArrayDeque<Character>();
    for(int i =0; i < expr.length(); i++) {
      char ch = expr.charAt(i);
      if(ch == '(' || ch == '[' || ch == '{') {
        deque.push(ch);
        continue;
      }

      if(deque.isEmpty()) {
        return false;
      }
      char check;
      switch (ch) {
        case ')':
          check = deque.pop();
          if(check == '{' || check == '[') {
            return false;
          }
          break;

        case '}':
          check = deque.pop();
          if(check == '(' || check == '[') {
            return false;
          }
          break;


        case ']':
          check = deque.pop();
          if(check == '{' || check == '(') {
            return false;
          }
          break;

         default:
           return false;
      }
    }
    return deque.isEmpty();
  }
}
