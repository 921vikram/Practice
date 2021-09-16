package graph;

import java.util.LinkedList;

public class Graph {
  // No. of vertices
  private int V;

  // Array  of lists for
  // Adjacency List Representation
  private LinkedList<Integer> adj[];

  public LinkedList<Integer>[] getAdj() {
    return adj;
  }

  // Constructor
  @SuppressWarnings("unchecked")
  public Graph(int v)
  {
    this.V = v;
    this.adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList();
  }

  // Function to add an edge into the graph
  void addEdge(int v, int w)
  {
    adj[v].add(w); // Add w to v's list.
  }

}
