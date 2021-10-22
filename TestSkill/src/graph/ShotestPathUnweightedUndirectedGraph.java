package graph;

import java.util.*;

public class ShotestPathUnweightedUndirectedGraph {
  // Driver Code
  public static void main(String args[])
  {
    UnDirectedGraph g = new UnDirectedGraph(13);

    g.addEdge(1, 10);
    g.addEdge(1, 8);
    g.addEdge(9, 10);

    g.addEdge(9, 8);
    g.addEdge(9, 0);
    g.addEdge(8, 12);
    g.addEdge(12, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(3, 7);


    g.addEdge(0, 11);
    g.addEdge(0, 7);
    g.addEdge(7, 11);
    g.addEdge(7, 6);
    g.addEdge(5, 6);

    shortestPath(10, 4, g, 13);


  }

  private static void shortestPath(int start, int end, UnDirectedGraph g, int noOfVertices) {
    int[] prev = solve(start, noOfVertices, g);

    ArrayList<Integer> pp = constructPath(start, end, prev);

    for(int i =0; i < pp.size(); i++) {
      System.out.println(i+" : "+pp.get(i));
    }
  }

  private static ArrayList<Integer> constructPath(int start, int end, int[] prev) {
    ArrayList<Integer> path = new ArrayList();
    for(Integer i = end; i!= -1 ; i = prev[i]) {
      path.add(i);
    }
    Collections.reverse(path);
    if(path.get(0) == start) {
      return path;
    } else {
      return new ArrayList<Integer>();
    }
  }

  private static int[] solve(int start, int noOfVertices, UnDirectedGraph g) {
    boolean[] visited = new boolean[noOfVertices];
    ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
    queue.add(start);
    visited[start] = true;
    int[] prev = new int[noOfVertices];
    Arrays.fill(prev, -1);

    while (!queue.isEmpty()) {
      int first = queue.removeFirst();
      for(Integer neighbour : g.getAdj()[first]) {
        if(!visited[neighbour]) {
          queue.add(neighbour);
          visited[neighbour] = true;
          prev[neighbour] = first;
        }
      }
    }
    return prev;
  }

}
