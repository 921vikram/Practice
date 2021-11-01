package tree;

import java.util.Arrays;

public class SubTreeOfBinaryTree {

  private static class Passing {
    int i;
    int m = 0;
    int n = 0;
  }

  // Driver program to test above functions
  public static void main(String args[])
  {
    SubTreeOfBinaryTree tree = new SubTreeOfBinaryTree();
    Node T = new Node('a');
    T.left = new Node('b');
    T.right = new Node('d');
    T.left.left = new Node('c');
    T.right.right = new Node('e');
    //          a
    //        b    d
    //    c           e

    Node S = new Node('a');
    S.left = new Node('b');
    S.right = new Node('d');
    S.left.left = new Node('c');
    //          a
    //        b    d
    //    c

    if (tree.isSubtree(T, S)) {
      System.out.println("Yes, S is a subtree of T");
    }
    else {
      System.out.println("No, S is not a subtree of T");
    }
  }

  private static void inOrderTraversalOfTree(Node t, char[] arr, Passing i) {
    if(null == t) {
      arr[i.i++] = '$';
      return;
    }
    inOrderTraversalOfTree(t.left, arr, i);
    arr[i.i++] = t.getStrValue();
    inOrderTraversalOfTree(t.right, arr, i);
  }

  private static void preOrderTraversalOfTree(Node t, char[] arr, Passing i) {
    if(null == t) {
      arr[i.i++] = '$';
      return;
    }
    arr[i.i++] = t.getStrValue();
    preOrderTraversalOfTree(t.left, arr, i);
    preOrderTraversalOfTree(t.right, arr, i);
  }

  private boolean isSubtree(Node t, Node s) {
    char[] inOrderT = new char[1000];
    Passing p = new Passing();
    inOrderTraversalOfTree(t, inOrderT, p);
    String s1 = String.valueOf(Arrays.copyOfRange(inOrderT, 0 , p.i));

    char[] preOrderT = new char[1000];
    Passing p1 = new Passing();
    preOrderTraversalOfTree(t, preOrderT, p1);
    String s2 = String.valueOf(Arrays.copyOfRange(preOrderT, 0 , p1.i));

    char[] inOrderS = new char[1000];
    Passing ps = new Passing();
    inOrderTraversalOfTree(s, inOrderS, ps);
    String s3 = String.valueOf(Arrays.copyOfRange(inOrderS, 0 , ps.i));


    char[] preOrderS = new char[1000];
    Passing ps1 = new Passing();
    preOrderTraversalOfTree(s, preOrderS, ps1);
    String s4 = String.valueOf(Arrays.copyOfRange(preOrderS, 0 , ps1.i));

    // Compare pre order of T & S
    if(s1.contains(s3) && s2.contains(s4)) {
      return true;
    }
    return false;
  }
}
