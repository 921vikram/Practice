package linklist;

import java.util.*;

/**
 * Least recently used object will be deleted
 */
public class LRUCacheLinkedHashSet {
  private final int CACHE_SIZE;
  private Set<Integer> elements;

  public LRUCacheLinkedHashSet(int capacity) {
    this.CACHE_SIZE = capacity;
    elements = new LinkedHashSet<Integer>(CACHE_SIZE);
  }

  public void refer(int element) {
    if(elements.contains(element)) {
      elements.remove(element);
    } else {
      if(elements.size() == CACHE_SIZE) {
        Iterator<Integer> itr = elements.iterator();
        int first = itr.next();
        elements.remove(first);
      }
    }
    elements.add(element);
  }

  public void display() {
    Iterator itr = elements.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next()+" ");
    }
  }

  public static void main(String args[]) {
    LRUCacheLinkedHashSet cache = new LRUCacheLinkedHashSet(4);
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
