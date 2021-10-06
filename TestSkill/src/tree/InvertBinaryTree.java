package tree;

public class InvertBinaryTree {

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
    printTree(n1);

    invertTree(n1);
    System.out.println();
    printTree(n1);
  }

  private static void printTree(Node n1) {
    if(null == n1) {
      return;
    }
    System.out.print(n1.getValue()+" ");
    printTree(n1.left);
    printTree(n1.right);
  }


  private static void invertTree(Node n1) {
    if(null == n1) {
      return;
    }

    Node left = n1.left;
    Node right = n1.right;

    n1.left = right;
    n1.right = left;

    invertTree(n1.left);
    invertTree(n1.right);
  }

  private static void invertTree2(Node n1) {
    if(null == n1) {
      return;
    }

    invertTree(n1.left);
    invertTree(n1.right);

    Node left = n1.left;
    n1.left = n1.right;
    n1.right = left;

  }

}
