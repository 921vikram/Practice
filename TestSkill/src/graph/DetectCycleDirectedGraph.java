package graph;

import java.util.Iterator;

public class DetectCycleDirectedGraph {

  private static boolean isCyclic(DirectedGraph graph, int V)
  {
    // Mark all the vertices as not visited and
    // not part of recursion stack
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];

    // Call the recursive helper function to
    // detect cycle in different DFS trees
    for (int i = 0; i < V; i++)
      if (isCyclicUtil(i, visited, recStack, graph))
        return true;

    return false;
  }

  private static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, DirectedGraph graph) {

    if(recStack[i]) {
      return true;
    }

    if(visited[i]) {
      return false;
    }

    visited[i] = true;
    recStack[i] = true;

    Iterator<Integer> itr = graph.getAdj().get(i).iterator();
    while (itr.hasNext()) {
      int c = itr.next();
      if(!visited[c]) {
        if(isCyclicUtil(c, visited, recStack, graph)) {
          return true;
        }
      }
    }

    recStack[i] = false;
    return false;

  }


  // Driver code
  public static void main(String[] args)
  {
    DirectedGraph graph = new DirectedGraph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    if(isCyclic(graph, 4))
      System.out.println("Graph contains cycle");
    else
      System.out.println("Graph doesn't "
        + "contain cycle");
  }

}
