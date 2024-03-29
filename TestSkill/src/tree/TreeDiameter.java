package tree;

public class TreeDiameter {

  public static int res = 0;

  public static void main(String args[]) {

    Node node = new Node(1);
    node.setLeft(new Node(2));
    node.setRight(new Node(3));

    Node n2 = new Node(5);
    n2.setLeft(new Node(6));
    n2.setRight(new Node(7));

    Node n1 = new Node(4);
    n1.setLeft(node);
    n1.setRight(n2);
    res = 0;
    treeDiameter(n1);
    System.out.println("Diameter of Tree " + res);
  }

  public static int treeDiameter(Node node) {
    if (null == node) {
      return 0;
    }
    int left = treeDiameter(node.getLeft());
    int right = treeDiameter(node.getRight());

    int tmp = Math.max(left, right) + 1;
    int ans = tmp < left + right + 1 ? left + right + 1 : tmp;

    res = res < ans ? ans : res;
    return tmp;
  }


}
