package dp.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

    int min = 0;
    int max = 0;
    int hd = 0;
    findHorizontalDistance(root, min, max, hd, map);

    for(List<Integer> values : map.values()) {
      System.out.println(values);
    }

  }

  private static void findHorizontalDistance(Node root, int min, int max, int hd, Map<Integer, List<Integer>> map) {

    if(root == null) {
      return;
    }

    if(hd < min) {
      min = hd;
    }

    if(hd > max) {
      max = hd;
    }

    map.computeIfAbsent(hd, k -> new ArrayList<Integer>()).add(root.getValue());

    findHorizontalDistance(root.left, min, max, hd -1 , map);

    findHorizontalDistance(root.right, min, max, hd +1 , map);

  }

}
