package graph;

import java.util.*;

public class DirectedGraph {
  private int vertices;
  private List<List<Integer>> adj;

  public int getVertices() {
    return vertices;
  }

  public void setVertices(int vertices) {
    this.vertices = vertices;
  }

  public List<List<Integer>> getAdj() {
    return adj;
  }

  public void setAdj(List<List<Integer>> adj) {
    this.adj = adj;
  }

  public DirectedGraph(int v) {
    this.vertices = v;
    adj = new ArrayList<>();
    for(int i =0; i<v;i++) {
      adj.add(new LinkedList<>());
    }
  }

  public void addEdge(int source, int dest) {
    adj.get(source).add(dest);
  }

}
