package tree;

public class RecoverTree {
  Node first, middle, last, prev;

  void correctBSTUtil(Node node) {
    if(null != node) {
      correctBSTUtil(node.left);
      if(null != prev && prev.getValue() > node.getValue()) {
        if (first == null) {
          first = prev;
          middle = node;
        } else {
          last = node;
        }
      }
      prev = node;
      correctBSTUtil(node.right);
    }
  }

  void correctBST(Node node) {
    first = middle = last = prev = null;
    correctBSTUtil(node);
    if(null != first && last != null) {
      int tmp = first.getValue();
      first.value = last.value;
      last.value = tmp;
    } else if (null != first && null != middle) {
      int tmp = first.getValue();
      first.value = middle.value;
      middle.value = tmp;
    }
  }

  void printInorder(Node node)
  {
    if (node == null)
      return;
    printInorder(node.left);
    System.out.print(" " + node.value);
    printInorder(node.right);
  }

  public static void main (String[] args)
  {
        /*   6
            / \
           10  2
          / \ / \
         1  3 7 12

        10 and 2 are swapped
        */

    Node root = new Node(6);
    root.left = new Node(10);
    root.right = new Node(2);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.right = new Node(12);
    root.right.left = new Node(7);

    System.out.println("Inorder Traversal"+
      " of the original tree");
    RecoverTree tree = new RecoverTree();
    tree.printInorder(root);

    tree.correctBST(root);

    System.out.println("\nInorder Traversal"+
      " of the fixed tree");
    tree.printInorder(root);
  }
}
