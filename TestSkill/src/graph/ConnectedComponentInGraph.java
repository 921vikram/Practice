package graph;

import java.util.Arrays;

public class ConnectedComponentInGraph {

  private static int count;
  private static int[] component;

  // Driver Code
  public static void main(String args[])
  {
    UnDirectedGraph g = new UnDirectedGraph(18);

    g.addEdge(6, 7);
    g.addEdge(7, 11);
    g.addEdge(6, 11);

    g.addEdge(0, 4);
    g.addEdge(0, 8);
    g.addEdge(0, 14);
    g.addEdge(0, 13);
    g.addEdge(4, 8);
    g.addEdge(8, 14);
    g.addEdge(14, 13);


    g.addEdge(1, 5);
    g.addEdge(5, 16);
    g.addEdge(16, 17);

    g.addEdge(3, 9);
    g.addEdge(2, 9);
    g.addEdge(2, 15);
    g.addEdge(15, 9);
    g.addEdge(15, 10);

    connectedComponent(2, g, 18);
   for(int i =0; i < component.length; i++) {
    System.out.println(i+" :"+component[i]);
   }

  }

  private static void connectedComponent(int startNode, UnDirectedGraph g, int noOfVertices) {
    boolean[] visited = new boolean[noOfVertices];
    count =0;
    component = new int[noOfVertices];
    for(int i =0 ; i< noOfVertices; i++) {
      if(!visited[i]) {
        count++;
        DFS(g, i, component, visited);
      }
    }

  }

  private static void DFS(UnDirectedGraph g, int i, int[] component, boolean[] visited) {
    visited[i] = true;
    component[i] = count;
    for(Integer neighbour : g.getAdj()[i]) {
      if(!visited[neighbour]) {
        DFS(g, neighbour, component, visited);
      }
    }

  }
}
