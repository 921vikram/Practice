package tree;

public class IsBST {

  public static void main(String args[]) {

    Node node = new Node(1);
//    node.setLeft(new Node(2));
//    node.setRight(new Node(3));

    Node n2 = new Node(5);
    n2.setLeft(new Node(3));
    n2.setRight(new Node(7));

    Node n1 = new Node(4);
    n1.setLeft(node);
    n1.setRight(n2);


    boolean res = isBST(n1);

    System.out.println("Is Binary Search Tree :  " + res);
  }

  private static boolean isBST(Node root) {
    if(null == root) {
      return false;
    }
    if(root.getRight() == null || root.getLeft() == null) {
      return true;
    }


    if(root.getValue() < root.getLeft().getValue()) {
      return false;
    } else if (root.getValue() > root.getRight().getValue()) {
      return false;
    } else if(root.getValue() > root.getLeft().getValue()){
      return  isBST(root.getLeft());
    } else if (root.getValue() < root.getRight().getValue()) {
      return isBST(root.getRight());
    } else {
      return false;
    }
  }

}
