package tree;

public class LevelOrderTraversalBTree {


  /* function to print level order traversal of tree*/
  static void printLevelOrder(Node root)
  {
    int h = height(root);
    int i;
    for (i=1; i<=h; i++) {
      System.out.print("Level "+i+" : ");
      printCurrentLevel(root, i);
    }
  }

  /* Print nodes at the current level */
  static void printCurrentLevel (Node root ,int level)
  {
    if (root == null)
      return;
    if (level == 1)
      System.out.print(root.getValue() + " ");
    else if (level > 1)
    {
      printCurrentLevel(root.left, level-1);
      printCurrentLevel(root.right, level-1);
    }
  }

  /* Compute the "height" of a tree -- the number of
   nodes along the longest path from the root node
   down to the farthest leaf node.*/
  static int height(Node root) {
    if (root == null) {
      return 0;
    } else {
      /* compute  height of each subtree */
      int lheight = height(root.left);
      int rheight = height(root.right);
      /* use the larger one */
      if (lheight > rheight)
        return (lheight + 1);
      else return (rheight + 1);
    }
  }


  /* Driver program to test above functions */
  public static void main(String args[])
  {
    Node tree = new Node(1);
    tree.left= new Node(2);
    tree.right= new Node(3);
    tree.left.left= new Node(4);
    tree.left.right= new Node(5);

    System.out.println("Level order traversal of binary tree is ");
    printLevelOrder(tree);
  }

}
