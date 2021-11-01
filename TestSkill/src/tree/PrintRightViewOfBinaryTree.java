package tree;

public class PrintRightViewOfBinaryTree {

  public static void main(String args[]) {

    Node tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(3);
    tree.left.left = new Node(4);
    tree.left.right = new Node(5);
    tree.right.left = new Node(6);
    tree.right.right = new Node(7);
    tree.right.left.right = new Node(8);

    MaxLevel maxLevel = new MaxLevel();
    printRightView(tree, 1, maxLevel);

  }

  /**
   * We need to use a reference as maxLevel value can be changed by multiple methods
   */
  private static class MaxLevel {
    int maxLevel;
  }

  private static void printRightView(Node root, int level, MaxLevel maxLevel) {
    if(root == null) {
      return;
    }

    if(maxLevel.maxLevel < level) {
      System.out.println(root.getValue());
      maxLevel.maxLevel = level;
    }
    /**
     * For Right view we will always choose right for a root element and increase a level so that
     * for every new level right of right element will be selected always
     */
    printRightView(root.right, level+1, maxLevel);

    printRightView(root.left, level+1, maxLevel);
  }


}
