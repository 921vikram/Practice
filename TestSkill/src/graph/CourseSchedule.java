package graph;

import java.util.Iterator;

public class CourseSchedule {


  public static void main(String args[]) {
    // Create a graph given in the above diagram
    DirectedGraph g = new DirectedGraph(4);
    g.addEdge(1, 0);
    g.addEdge(2, 1);
    g.addEdge(3, 2);

//    g.addEdge(1, 0);
//    g.addEdge(0, 1);

    System.out.println("Courses can be finished : " + canFinish(g));
  }

  private static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, DirectedGraph graph) {

    if (visited[i]) {
      return false;
    }

    visited[i] = true;
    recStack[i] = true;

    Iterator<Integer> itr = graph.getAdj().get(i).iterator();
    while (itr.hasNext()) {
      int c = itr.next();
      if (recStack[c] || isCyclicUtil(c, visited, recStack, graph)) {
        return true;
      }
    }
    recStack[i] = false;
    return false;
  }


  private static boolean canFinish(DirectedGraph g) {
    // Mark all the vertices as not visited
    boolean visited[] = new boolean[g.getVertices()];
    boolean scale[] = new boolean[g.getVertices()];
    for (int i = 0; i < g.getVertices(); i++)
      visited[i] = false;

    // Call the recursive helper
    // function to store
    // Topological Sort starting
    // from all vertices one by one
    for (int i = 0; i < g.getVertices(); i++)
      if (!visited[i] && isCyclicUtil(i, visited, scale, g)) {
        return false;
      }

    return true;

  }


}
