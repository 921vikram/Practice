package test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class test11 {


  /**
   * Input as Undirected graph
   * Nodes and edges
   * count number of connected component
   *
   * 5 nodes
   * 0 1 2 3 4
   * 0-1 0-3
   *
   */

  private static class UndirectedGraph {
    int size;
    List<Integer> adj[];

    public UndirectedGraph(int size) {
      this.size = size;
      adj = new List[size];
      for(int i=0; i < size; i++) {
        adj[i] = new LinkedList<Integer>();
      }
    }

    void addEdge(int src, int dest) {
      adj[src].add(dest);
      adj[dest].add(src);
    }
  }

  private static void printNumberOfConnectedComp(UndirectedGraph g) {
    boolean[] visited = new boolean[g.size];

    int count = 0;
    for(int i =0;i < g.size; i++) {
      if(!visited[i]) {
        visit(g, i, visited);
        count++;
      }
    }

    System.out.println("Number of connected component "+count);
  }

  private static void visit(UndirectedGraph g, int i, boolean[] visited) {
    visited[i] = true;
    Iterator<Integer> itr = g.adj[i].iterator();
    while(itr.hasNext()) {
      Integer c = itr.next();
      if(!visited[c]) {
        visit(g,c,visited);
      }
    }
  }


  public static void main(String[] args) {
    // size is number of nodes
    UndirectedGraph g = new UndirectedGraph(5);
    g.addEdge(0, 3);
    g.addEdge(0, 2);
    g.addEdge(1,4);
    g.addEdge(4,2);

    printNumberOfConnectedComp(g);
  }


}
