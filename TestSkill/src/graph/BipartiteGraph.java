package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

  private int V;   // No. of vertices
  private LinkedList<Integer> adj[]; //Adjacency List

  private static class  Pair<T>  {
    T first;
    T second;
    public Pair(T first, T second) {
      this.first = first;
      this.second = second;
    }
  }

  //Constructor Undirected graph
  BipartiteGraph(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i=0; i<v; ++i)
      adj[i] = new LinkedList();
  }

  //Function to add an edge into the graph
  void addEdge(int v,int w)
  {
    adj[v].add(w);
    adj[w].add(v); //Graph is undirected
  }

  private boolean isBipartiteGraph() {

    Queue<Pair> q = new LinkedList<Pair>();
    int[] colors = new int[V];
    Arrays.fill(colors, -1);

    for(int u=0; u<V; u++) {
      if(colors[u] == -1) {
        q.add(new Pair(u, 0));
        colors[u] = 0;

        while(!q.isEmpty()) {
          Pair p = q.poll();
          int vertex = (int)p.first;
          int color = (int)p.second;

          Iterator<Integer> itr = adj[vertex].iterator();
          while(itr.hasNext()) {
            Integer c = itr.next();
            if(color == colors[c]) {
              return false;
            }
            if(colors[c] == -1) {
              colors[c] = color ==1 ? 0 : 1;
              q.add(new Pair(c,colors[c]));
            }

          }

        }

      }

    }
    return true;
  }

  // Driver method
  public static void main(String args[])
  {
    BipartiteGraph g1 = new BipartiteGraph(4);
    g1.addEdge(0, 1);
    g1.addEdge(0, 3);
    g1.addEdge(1, 2);
    g1.addEdge(2, 3);

    System.out.println("Is Graph Bipartite "+g1.isBipartiteGraph());


    System.out.println();
    BipartiteGraph g2 = new BipartiteGraph(5);
    g2.addEdge(0, 1);
    g2.addEdge(0, 2);
    g2.addEdge(1, 2);
    g2.addEdge(1, 4);
    g2.addEdge(2, 4);
    g2.addEdge(4, 3);
    System.out.println("Is Graph Bipartite "+g2.isBipartiteGraph());

  }


}
