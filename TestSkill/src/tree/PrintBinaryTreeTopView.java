package tree;

import java.util.*;

public class PrintBinaryTreeTopView {

  private static class QNode {
    int hd;
    Node node;
    public QNode(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

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
    printTopView(root);
  }

  private static void printTopView(Node root) {
    if(null == root) {
      return;
    }
    Map<Integer,Node> map =new TreeMap<Integer,Node>();
    int hd  = 0;
    Queue<QNode> queue = new LinkedList<QNode>();
    queue.add(new QNode(root, hd));

    while(!queue.isEmpty()) {
      QNode qNode = queue.poll();
      if(!map.containsKey(qNode.hd)) {
        map.put(qNode.hd, qNode.node);
      }

      if(qNode.node.left != null) {
        queue.add(new QNode(qNode.node.left, qNode.hd - 1));
      }

      if(qNode.node.right != null) {
        queue.add(new QNode(qNode.node.right, qNode.hd + 1));
      }
    }

    for(Map.Entry<Integer, Node> entry : map.entrySet()) {
      System.out.println(entry.getKey()+" value "+entry.getValue().getValue());
    }

  }


}
