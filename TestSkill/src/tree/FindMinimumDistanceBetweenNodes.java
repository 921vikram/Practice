package tree;

public class FindMinimumDistanceBetweenNodes {

  private static class node{
    int data;
    node left, right;
  }

  public static void main(String[] args)
  {
    /**
     *        5
     *      7     3
     *    9   6
     *       1  4
     */
    node root = create(5);
    root.left = create(7);
    root.right = create(3);
    root.left.left = create(9);
    root.left.right = create(6);
    root.left.right.left = create(1);
    root.left.right.right = create(4);
    System.out.println("Distance between nodes 9 and 4 : "+computeMinDistance(root, 9, 4));
    System.out.println("Distance between nodes 4 and 4 : "+computeMinDistance(root, 4, 4));
    System.out.println("Distance between nodes 4 and 3 : "+computeMinDistance(root, 4, 3));
  }

  private static int findDistance(node root, int n1, int level) {
    if(null == root) {
      return -1;
    }
    if(root.data == n1) {
      return level;
    }
    int left = findDistance(root.left, n1, level+1);
    int right= findDistance(root.right, n1, level+1);
    return left != -1 ? left : right;
  }


  static node findLCA(node root, int n1, int n2){
    if(root == null)
      return null;
    if(root.data == n1 || root.data == n2){
      return root;
    } else {
      // check if leftSubTree has n1 or n2 or both
      node leftSubTree = findLCA(root.left, n1, n2);
      // check if rightSubTree has n1 or n2 or both
      node rightSubTree = findLCA(root.right, n1, n2);
      if(leftSubTree != null && rightSubTree != null)
        return root;
      // if we don't find one nodes in left and one node in right subtree
      // then the lca must be either in left subtree or right subtree
      return (leftSubTree != null) ? leftSubTree : rightSubTree;
    }
  }


  private static int computeMinDistance(node root, int n1, int n2) {
    int Level1 = findDistance(root, n1, 0);
    int level2 = findDistance(root, n2, 0);
    node lca = findLCA(root, n1, n2);
    System.out.println("LCA "+lca.data);
    int lcaDistance = findDistance(root, lca.data, 0);

    return Level1 + level2 - 2*lcaDistance;
  }

  private static node create(int data) {
      node tmp = new node();
      tmp.data = data;
      tmp.left = tmp.right = null;
      return tmp;
    }
  }



