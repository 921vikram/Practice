package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CenterOfUndirectedTree {

  // Create an empty tree as a adjacency list.
  public static List<List<Integer>> createEmptyTree(int n) {
    List<List<Integer>> tree = new ArrayList<>(n);
    for (int i = 0; i < n; i++)
      tree.add(new LinkedList<>());
    return tree;
  }

  public static void addUndirectedEdge(List<List<Integer>> tree, int from, int to) {
    tree.get(from).add(to);
    tree.get(to).add(from);
  }

  // Driver Code
  public static void main(String args[])
  {
    List<List<Integer>> graph = createEmptyTree(9);

    addUndirectedEdge(graph, 0, 1);
    addUndirectedEdge(graph, 2, 1);
    addUndirectedEdge(graph, 2, 3);
    addUndirectedEdge(graph, 3, 4);
    addUndirectedEdge(graph, 5, 3);
    addUndirectedEdge(graph, 2, 6);
    addUndirectedEdge(graph, 6, 7);
    addUndirectedEdge(graph, 6, 8);

    // Centers are 2
    System.out.println(findTreeCenters(graph));

// Centers are 0
    List<List<Integer>> graph2 = createEmptyTree(1);
    System.out.println(findTreeCenters(graph2));

    // Centers are 0,1
    List<List<Integer>> graph3 = createEmptyTree(2);
    addUndirectedEdge(graph3, 0, 1);
    System.out.println(findTreeCenters(graph3));

    // Centers are 1
    List<List<Integer>> graph4 = createEmptyTree(3);
    addUndirectedEdge(graph4, 0, 1);
    addUndirectedEdge(graph4, 1, 2);
    System.out.println(findTreeCenters(graph4));

    // Centers are 1,2
    List<List<Integer>> graph5 = createEmptyTree(4);
    addUndirectedEdge(graph5, 0, 1);
    addUndirectedEdge(graph5, 1, 2);
    addUndirectedEdge(graph5, 2, 3);
    System.out.println(findTreeCenters(graph5));

    // Centers are 2,3
    List<List<Integer>> graph6 = createEmptyTree(7);
    addUndirectedEdge(graph6, 0, 1);
    addUndirectedEdge(graph6, 1, 2);
    addUndirectedEdge(graph6, 2, 3);
    addUndirectedEdge(graph6, 3, 4);
    addUndirectedEdge(graph6, 4, 5);
    addUndirectedEdge(graph6, 4, 6);
    System.out.println(findTreeCenters(graph6));

  }

  private static List<Integer> findTreeCenters(List<List<Integer>> tree) {
    final int n = tree.size();
    int[] degres = new int[n];

    List<Integer> leaves = new ArrayList<>();
    for(int i =0; i< n; i++) {
      List<Integer> edges = tree.get(i);
      degres[i] = edges.size();
      if(degres[i] <=1) {
        leaves.add(i);
        degres[i] = 0;
      }
    }

    int processedLeaves = leaves.size();


    while(processedLeaves < n) {
      List<Integer> newLeaves = new ArrayList<>();
      for(Integer node : leaves) {
        for(int neighbour : tree.get(node)) {
          if(--degres[neighbour] == 1) {
            newLeaves.add(neighbour);
          }
        }
        degres[node] =0;
      }
      processedLeaves +=newLeaves.size();
      leaves = newLeaves;
    }
    return leaves;
  }

}
