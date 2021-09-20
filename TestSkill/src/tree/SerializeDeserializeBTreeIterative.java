package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerializeDeserializeBTreeIterative {
  // Encodes a tree to a single string.
  public static String serialize(Node root)
  {
    if (root == null) {
      return null;
    }
    Stack<Node> s = new Stack<>();
    s.push(root);

    List<String> l = new ArrayList<>();
    while (!s.isEmpty()) {
      Node t = s.pop();
      // If current node is NULL, store marker
      if (t == null) {
        l.add("#");
      }
      else {
        // Else, store current node and recur for
        // its children
        l.add("" + t.getValue());
        s.push(t.right);
        s.push(t.left);
      }
    }
    return String.join(",", l);
  }
  static int t;
  // Decodes your encoded data to tree.
  public static Node deserialize(String data)
  {
    if (data == null)
      return null;
    t = 0;
    String[] arr = data.split(",");
    return helper(arr);
  }

  public static Node helper(String[] arr)
  {
    if (arr[t].equals("#"))
      return null;
    // create node with this item and recur for children
    Node root = new Node(Integer.parseInt(arr[t]));
    t++;
    root.left = helper(arr);
    t++;
    root.right = helper(arr);
    return root;
  }

  /* Driver program to test above functions*/
  public static void main(String args[])
  {
    // Let us construct a tree shown in the above figure
    Node tree = new Node(20);
    tree.left = new Node(8);
    tree.right = new Node(22);
    tree.left.left = new Node(4);
    tree.left.right = new Node(12);
    tree.left.right.left = new Node(10);
    tree.left.right.right = new Node(14);

    String serialized = serialize(tree);
    System.out.println("Serialized view of the tree:");
    System.out.println(serialized);
    System.out.println();

    // Let us deserialize the stored tree into root1
    Node t = deserialize(serialized);

    System.out.println(
      "Inorder Traversal of the tree constructed from serialized String:");
    inorder(t);
  }

  // A simple inorder traversal used for testing the
  // constructed tree
  static void inorder(Node root)
  {
    if (root != null) {
      inorder(root.left);
      System.out.print(root.getValue() + " ");
      inorder(root.right);
    }
  }

}
