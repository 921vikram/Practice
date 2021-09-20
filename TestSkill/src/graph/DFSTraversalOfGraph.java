package graph;

import java.util.Iterator;

public class DFSTraversalOfGraph {




  // Driver Code
  public static void main(String args[])
  {
    UnDirectedGraph g = new UnDirectedGraph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println(
      "Following is Depth First Traversal "
        + "(starting from vertex 2)");

    DFS(2, g, 4);
  }

  private static void DFS(int v, UnDirectedGraph g, int V) {
    boolean[] visited = new boolean[V];
    DFSUtil(v, visited, g);
  }

  private static void DFSUtil(int v, boolean[] visited, UnDirectedGraph g) {
    visited[v] = true;
    System.out.println(" "+v+" ");
    Iterator<Integer> itr = g.getAdj()[v].iterator();
    while(itr.hasNext()) {
      int n = itr.next();
      if(!visited[n]) {
        // calling till last depth and all the previous method call will be on stack.
        DFSUtil(n, visited, g);
      }
    }
  }
}
