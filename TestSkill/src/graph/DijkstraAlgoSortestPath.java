package graph;

public class DijkstraAlgoSortestPath {

  private static int V = 9;

  // Driver method
  public static void main(String[] args)
  {
    /* Let us create the example graph discussed above */
    int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
    DijkstraAlgoSortestPath t = new DijkstraAlgoSortestPath();
    t.dijkstra(graph, 0);
  }

  private void dijkstra(int[][] graph, int i) {
    int dist[] = new int[V];
    Boolean[] sptSet = new Boolean[V];

    for(int j =0; j< V; j++) {
      dist[j] = Integer.MAX_VALUE;
      sptSet[j] = false;
    }

    dist[i] = 0;
    for(int count = 0; count < V-1; count ++) {
      int u = minDistance(dist, sptSet);
      sptSet[u] = true;
      for(int v =0;v< V;v++) {
        if(!sptSet[v] && graph[u][v] !=0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
          dist[v] = dist[u] + graph[u][v];
        }
      }
    }

    printSolution(dist);

  }

  private void printSolution(int[] dist) {
    System.out.println("Vertex \t\t Distance from Source");
    for (int i = 0; i < V; i++)
      System.out.println(i + " \t\t " + dist[i]);
  }

  private int minDistance(int[] dist, Boolean[] sptSet) {
    int min = Integer.MAX_VALUE, minIdex = -1;
    for(int v = 0; v < V; v++) {
      if (sptSet[v] == false && dist[v] <=min) {
        min = dist[v];
        minIdex = v;
      }
    }
    return minIdex;
  }


}
