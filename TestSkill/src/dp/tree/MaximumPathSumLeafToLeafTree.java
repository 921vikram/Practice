package dp.tree;

import dp.tree.Node;

public class MaximumPathSumLeafToLeafTree {

  public static int res = 0;

  public static void main(String args[]) {

    Node node = new Node(1);
    node.setLeft(new Node(2));
    node.setRight(new Node(3));

    Node n2 = new Node(-50);
    n2.setLeft(new Node(6));
    n2.setRight(new Node(7));

    Node n1 = new Node(4);
    n1.setLeft(node);
    n1.setRight(n2);
    res = 0;
    treeDiameter(n1);
    System.out.println("Mximum path sum for Tree " + res);
  }

  public static int treeDiameter(Node node) {
    if (null == node) {
      return 0;
    }
    int left = treeDiameter(node.getLeft());
    int right = treeDiameter(node.getRight());

    int tmp = left > right ? left + node.getValue() : right + node.getValue();
    if (node.getLeft() == null && node.getRight() == null) {
      tmp = tmp > node.getValue() ? tmp : node.getValue();
    }
    int ans = tmp < left + right + node.getValue() ? left + right + node.getValue() : tmp;

    res = res < ans ? ans : res;
    return tmp;
  }


}
