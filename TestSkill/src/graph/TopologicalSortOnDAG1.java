package graph;

import java.util.*;

/**
 * Directed Acyclic Graph
 */
public class TopologicalSortOnDAG1 {

  private static class DirectedGraph {

    public List<List<Integer>> adjList;
    public int size;



    public DirectedGraph(int cap) {
      this.size = cap;
      this.adjList = new ArrayList<>();
      for(int i = 0 ; i < cap; i++) {
        this.adjList.add(new LinkedList<Integer>());
      }
    }

    public void add(int src, int dest) {
      this.adjList.get(src).add(dest);
    }

  }



  private static void findPath(int i, DirectedGraph dg, boolean[] visited, Stack<Integer> stack) {

    visited[i] = true;
    stack.push(i);

    Iterator<Integer> itr = dg.adjList.get(i).iterator();
    while(itr.hasNext()) {
      int c = itr.next();
      if(!visited[c]) {
        findPath(c,dg,visited,stack);
      }
    }


  }



  public static void main(String args[]) {

    DirectedGraph dg = new DirectedGraph(6);
    dg.add(5, 2);
    dg.add(5, 0);
    dg.add(4, 0);
    dg.add(4, 1);
    dg.add(2, 3);
    dg.add(3, 1);
//
//    dg.add(0,1);
//    dg.add(1,3);
//    dg.add(3,4);
//    dg.add(2,4);
//    dg.add(1,2);

    boolean[] visited = new boolean[6];
    Stack<Integer> stack = new Stack<Integer>();


    for(int i =0 ; i < 6; i++) {
      findPath(i,dg,visited, stack);
    }

    Set<Integer> set = new HashSet<Integer>();
    while(!stack.isEmpty()) {
      Integer tmp = stack.pop();
      if(set.add(tmp)) {
        System.out.println(tmp);
      }
    }
  }

}
