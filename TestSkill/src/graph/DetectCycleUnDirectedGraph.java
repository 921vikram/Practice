package graph;

import java.util.Iterator;

public class DetectCycleUnDirectedGraph {
  // Returns true if the graph contains a
  // cycle, else false.
  // This function is a variation of DFS() in
  // https://www.geeksforgeeks.org/archives/18212
  private static boolean isCyclic(UnDirectedGraph graph, int V)
  {

    // Mark all the vertices as not visited and
    // not part of recursion stack
    boolean[] visited = new boolean[V];

    // Call the recursive helper function to
    // detect cycle in different DFS trees
    for (int i = 0; i < V; i++)
      if (isCyclicUtil(i, visited, -1, graph))
        return true;

    return false;
  }

  private static boolean isCyclicUtil(int i, boolean[] visited, int parent, UnDirectedGraph graph) {

    if(visited[i]) {
      return false;
    }

    visited[i] = true;

    Iterator<Integer> itr = graph.getAdj()[i].iterator();
    while (itr.hasNext()) {
      int c = itr.next();
      if(!visited[c]) {
        return  isCyclicUtil(c, visited, i, graph);
      } else if (c != parent) {
        return true;
      }
    }
    return false;
  }


  // Driver code
  public static void main(String[] args)
  {
    // Create a graph given
    // in the above diagram
    UnDirectedGraph g1 = new UnDirectedGraph(5);
    g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(2, 1);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    if (isCyclic(g1,5))
      System.out.println("Graph contains cycle");
    else
      System.out.println("Graph doesn't contains cycle");

    UnDirectedGraph g2 = new UnDirectedGraph(3);
    g2.addEdge(0, 1);
    g2.addEdge(1, 2);
    if (isCyclic(g2, 3))
      System.out.println("Graph contains cycle");
    else
      System.out.println("Graph doesn't contains cycle");
  }

}
