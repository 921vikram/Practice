package graph;

import java.util.LinkedList;

public class UnDirectedGraph {
  // No. of vertices
  private int V;

  public int getV() {
    return V;
  }

  public void setV(int v) {
    V = v;
  }

  // Array  of lists for
  // Adjacency List Representation
  private LinkedList<Integer> adj[];

  public LinkedList<Integer>[] getAdj() {
    return adj;
  }

  // Constructor
  @SuppressWarnings("unchecked")
  public UnDirectedGraph(int v)
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
    adj[w].add(v);
  }

}
