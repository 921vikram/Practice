package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSTraversalOfGraph {




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

    BFS(2, g, 4);
    
  }

  private static void BFS(int element, UnDirectedGraph g, int vertexes) {
    boolean[] visited = new boolean[vertexes];

    // queue for BFS
    LinkedList<Integer> queue = new LinkedList<Integer>();

    visited[element] = true;
    queue.add(element);

    while (queue.size() !=0) {
      element = queue.poll();
      System.out.println(" "+element+" ");

      Iterator<Integer> itr = g.getAdj()[element].iterator();
      while (itr.hasNext()) {
        int n = itr.next();
        if(!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }


  }

}
