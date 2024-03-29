package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Print the tree nodes with comes in a single vertical line
 *               1
 *          2         3
 *       4      5/6       7
 *                    8      9
 */
public class PrintBinaryTreeVerticalOrder {

  public static void main(String args[]) {

    // TO DO Auto-generated method stub
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);
    root.right.right.right = new Node(9);
    System.out.println("Vertical Order traversal is");
    printVerticalOrder(root);
  }

  private static void printVerticalOrder(Node root) {
    if(root == null) {
      return;
    }

    Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
    int hd = 0;
    findHorizontalDistance(root,hd, map);

    for(List<Integer> values : map.values()) {
      System.out.println(values);
    }
  }

  private static void findHorizontalDistance(Node root, int hd, Map<Integer, List<Integer>> map) {
    if(root == null) {
      return;
    }
//    if(hd < min) {
//      min = hd;
//    }
//
//    if(hd > max) {
//      max = hd;
//    }
    /**
     *  HD will capture the left and right movement. Left movement means -1 and right movement means +1
     **/
    map.computeIfAbsent(hd, k -> new ArrayList<Integer>()).add(root.getValue());

    findHorizontalDistance(root.left, hd -1 , map);

    findHorizontalDistance(root.right, hd +1 , map);

  }

}
