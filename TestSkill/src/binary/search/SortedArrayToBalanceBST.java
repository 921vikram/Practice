package binary.search;

public class SortedArrayToBalanceBST {

  static Node root;

  Node sortedArrayToBst(int[] arr, int start, int end) {
    if(start > end) {
      return null;
    }
    int mid = start + (end-start)/2;
    Node newNode = new Node(arr[mid]);

    newNode.left = sortedArrayToBst(arr,start, mid -1);
    newNode.right = sortedArrayToBst(arr, mid+1, end);

    return newNode;
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

    SortedArrayToBalanceBST bst = new SortedArrayToBalanceBST();
    int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
    int n = arr.length;
    root = bst.sortedArrayToBst(arr, 0, n-1);
    bst.printPreOrderTree(root);
  }

  //        4
  //     2       6
  //  1     3  5    7


}
