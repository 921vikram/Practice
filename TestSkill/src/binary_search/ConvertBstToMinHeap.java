package binary_search;

import java.util.ArrayList;

public class ConvertBstToMinHeap {

  static Node root;

  public void bstToSortedArray(Node node, ArrayList<Integer> arr) {
    if(null == node) {
      return;
    }
    bstToSortedArray(node.left, arr);
    arr.add(node.value);
    bstToSortedArray(node.right, arr);
  }

  private static int index = 0;
  public void sortedArrayToMinHeap(ArrayList<Integer> arr, Node node) {
   if(null == node) {
     return;
   }
   node.value = arr.get(index++);
   sortedArrayToMinHeap(arr, node.left);
   sortedArrayToMinHeap(arr, node.right);
  }

  void printPreOrderTree(Node node) {
    if(null == node) {
      return;
    }
    System.out.println("Node value "+node.value);
    printPreOrderTree(node.left);
    printPreOrderTree(node.right);
  }

  public static void main(String args[]) {

    // BST formation
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(6);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.left = new Node(5);
    root.right.right = new Node(7);


    ConvertBstToMinHeap bst = new ConvertBstToMinHeap();
    bst.printPreOrderTree(root);

    ArrayList<Integer> arr = new ArrayList<>();
    bst.bstToSortedArray(root, arr);

    // print sorted array
    for(int i = 0; i< arr.size(); i ++) {
      System.out.print(arr.get(i));
    }

    bst.sortedArrayToMinHeap(arr, root);
    System.out.println("Finallllllllllllllllllllllll");
    // pre order traversal of min heap will give minimum element first
    bst.printPreOrderTree(root);
  }

  //        4
  //     2       6
  //  1     3  5    7

  // output min heap---
  //        1
  //     2     5
  //   3   4  6  7


}
