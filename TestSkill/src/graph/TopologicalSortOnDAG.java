package graph;

import java.util.Iterator;
import java.util.Stack;

/**
 * Directed Acyclic Graph
 */
public class TopologicalSortOnDAG {
  public static void main(String args[]) {
    // Create a graph given in the above diagram
    DirectedGraph g = new DirectedGraph(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);

    System.out.println("Following is a Topological "
      + "sort of the given graph");
    // Function Call
    topologicalSort(g);
  }

  private static void topologicalSort(DirectedGraph g) {
    Stack<Integer> stack = new Stack<Integer>();

    // Mark all the vertices as not visited
    boolean visited[] = new boolean[g.getVertices()];
    for (int i = 0; i < g.getVertices(); i++)
      visited[i] = false;

    // Call the recursive helper
    // function to store
    // Topological Sort starting
    // from all vertices one by one
    for (int i = 0; i < g.getVertices(); i++)
      if (visited[i] == false)
        topologicalSortUtil(i, visited, stack, g);

    // Print contents of stack
    while (stack.empty() == false)
      System.out.print(stack.pop() + " ");
  }

  private static void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack, DirectedGraph g) {
    visited[i] = true;
    Iterator<Integer> itr = g.getAdj().get(i).iterator();
    while (itr.hasNext()) {
      int c = itr.next();
      if(!visited[c]) {
        topologicalSortUtil(c, visited, stack, g);
      }
    }
    stack.push(i);
  }
}
