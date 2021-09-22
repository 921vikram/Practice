package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversalBTree {

  /* Given a binary tree. Print
     its nodes in level order
     using array for implementing queue  */
  static void printLevelOrder(Node root) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node tempNode = queue.poll();
      System.out.print(tempNode.getValue() + " ");

      /*Enqueue left child */
      if (tempNode.left != null) {
        queue.add(tempNode.left);
      }

      /*Enqueue right child */
      if (tempNode.right != null) {
        queue.add(tempNode.right);
      }
    }
  }

  /* Driver program to test above functions */
  public static void main(String args[]) {
    Node tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(3);
    tree.left.left = new Node(4);
    tree.left.right = new Node(5);

    System.out.println("Level order traversal of binary tree is ");
    printLevelOrder(tree);
  }

}
