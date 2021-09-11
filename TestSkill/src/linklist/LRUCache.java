package linklist;

import java.util.*;

/**
 * Least recently used object will be deleted
 */
public class LRUCache {
  private final int CACHE_SIZE;
  private Deque<Integer> elements;
  private Set<Integer> set;

  public LRUCache(int capacity) {
    this.CACHE_SIZE = capacity;
    elements = new LinkedList<Integer>();
    set = new HashSet<Integer>();
  }

  public void refer(int element) {
    if(set.contains(element)) {
      elements.remove(element);
    } else {
      if(elements.size() == CACHE_SIZE) {
        int last = elements.removeLast();
        set.remove(last);
      }
    }
    set.add(element);
    elements.push(element);
  }

  public void display() {
    Iterator itr = elements.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next()+" ");
    }
  }

  public static void main(String args[]) {
    LRUCache cache = new LRUCache(4);
    cache.refer(1);
    cache.refer(2);
    cache.refer(3);
    cache.refer(1);
    cache.refer(4);
    cache.refer(5);
    cache.refer(2);
    cache.refer(2);
    cache.refer(1);
    cache.display();
  }

}
