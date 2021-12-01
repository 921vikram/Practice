package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CountNoOfConnectedComponent {

  private int v;
  private int e;
  private Map<Integer, HashSet<Integer>> adjMap;
  private static Map<Integer, Integer> visited;

  public CountNoOfConnectedComponent(int vertices)
  {
    v = vertices;
    adjMap = new HashMap<Integer, HashSet<Integer>>();
    visited = new HashMap<Integer, Integer>();
  }

  // Function to add edges
  private void addEdge(int s, int d)
  {
    adjMap.putIfAbsent(s, new HashSet<Integer>());
    adjMap.putIfAbsent(d, new HashSet<Integer>());
    adjMap.get(s).add(d);
    adjMap.get(s).add(s);
    adjMap.get(d).add(s);
    adjMap.get(d).add(d);
    visited.put(s, 0);
    visited.put(d, 0);
  }

  // To mark vertices which can be visites
  private void findDFS(int vertex) {
    // Mark as visited
    visited.put(vertex,1);
    // Print the vertex
    System.out.println("vertex " + vertex +
      " visited");
    for(Integer child : adjMap.get(vertex))
    {
      if(visited.get(child) == 0){
        findDFS(child);
      }
    }
  }
  // Function to print graph
  private void printGraph()
  {
    for(HashSet<Integer> v :
      adjMap.values())
    {
      System.out.println(v.toString());
    }
  }

  // Driver Code
  public static void main(String args[])
  {

    int vertices = 6;

    System.out.println("Enter the number of edges (E): ");
    int edges = 3;
    int ccCount =0;
    CountNoOfConnectedComponent ccc = new CountNoOfConnectedComponent(vertices);

    System.out.println("Enter the nodes s & d: ");
    ccc.addEdge(1,5);
    ccc.addEdge(0,2);
    ccc.addEdge(2,4);


    // Function to print graph
    ccc.printGraph();

    // Traversing every node
    for(Integer vertex : visited.keySet())
    {

      // Check if vertex is already
      // visited  or not
      if(visited.get(vertex) == 0)
      {

        // Function Call for findDFS
        ccc.findDFS(vertex);

        // Print Component Found
        System.out.println("CC Found");

        // Increase the counter
        ccCount++;
      }
    }

    // Print number of components
    System.out.println("Number of cc component: " + ccCount);
  }



}
