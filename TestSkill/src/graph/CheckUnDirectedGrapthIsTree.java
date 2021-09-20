package graph;

import java.util.Iterator;

public class CheckUnDirectedGrapthIsTree {

  private static boolean isValidTree(UnDirectedGraph graph)
  {
    boolean[] visited = new boolean[graph.getV()];
    for(int i=0; i< graph.getV(); i++) {
      visited[i] = false;
    }
    // Call the recursive helper function to
    // detect cycle in different DFS trees
    if (isCyclicUtil(0, visited, -1, graph))
        return false;
    //Check if all the nodes are visited if not then it's not valid tree. It will be disconnected graph
    for(int i=0; i< graph.getV(); i++) {
      if(!visited[i]) {
        return false;
      }
    }
    return true;
  }

  private static boolean isCyclicUtil(int i, boolean[] visited, int parent, UnDirectedGraph graph) {

    visited[i] = true;
    Iterator<Integer> itr = graph.getAdj()[i].iterator();
    while (itr.hasNext()) {
      int c = itr.next();
      if(!visited[c]) {
        if(isCyclicUtil(c, visited, i, graph)) {
          return true;
        }
      } else if (c != parent) {
        return true;
      }
    }
    return false;
  }


  // Driver code
  public static void main(String[] args)
  {
    // Create a graph given in the above diagram
    UnDirectedGraph g1 = new UnDirectedGraph(5);
    g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    if (isValidTree(g1))
      System.out.println("Graph is Tree");
    else
      System.out.println("Graph is not Tree");

    UnDirectedGraph g2 = new UnDirectedGraph(5);
    g2.addEdge(1, 0);
    g2.addEdge(0, 2);
    g2.addEdge(2, 1);
    g2.addEdge(0, 3);
    g2.addEdge(3, 4);

    if (isValidTree(g2))
      System.out.println("Graph is Tree");
    else
      System.out.println("Graph is not Tree");
  }

}
