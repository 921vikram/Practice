package linklist;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Least Frequently used we can use min heap to store the
 */
public class LFUCache {

  private static class Cache { // a class to remember frequency and recentness
    int key, f, r;
    public Cache(int k, int f, int r) {key=k;this.f=f;this.r=r;}
    // override equals() and hashCode()
    public boolean equals(Object object) {return key==((Cache) object).key;}
    public int hashCode() {return key;}
  }

  int capacity, id;
  HashMap<Integer, Integer> hashMap, frequency;
  PriorityQueue<Cache> queue;

  public LFUCache(int capacity) {
    this.capacity=capacity;
    id=0;
    hashMap=new HashMap<>();
    frequency=new HashMap<>();
    // sort by frequency and recentness
    queue =new PriorityQueue<>((o1,o2) -> o1.f==o2.f?o1.r-o2.r:o1.f-o2.f);
  }

  public int get(int key) {
    id++;
    if (hashMap.containsKey(key)) {
      update(key);
      return hashMap.get(key);
    }
    return -1;
  }

  public void set(int key, int value) {
    if (capacity==0) return;
    id++;
    if (hashMap.containsKey(key)) {
      update(key);
      hashMap.put(key, value);
      return;
    }
    if (hashMap.size()==capacity) {
      Cache first= queue.poll(); // find the smallest one, and remove it
      hashMap.remove(first.key);
      frequency.remove(first.key);
    }
    hashMap.put(key, value);
    frequency.put(key, 1);
    queue.add(new Cache(key, 1, id));
  }

  private void update(int key) { // update the priority queue
    int f=frequency.get(key);
    frequency.put(key, f+1); // get and update the frequency
    Cache cache=new Cache(key, f+1, id); // make a new Cache
    // remove the member in queue, if its key equals to the current key.
    // Here, queue uses `equals()` to judge the equality
    queue.remove(cache);
    queue.add(cache); // add the current Cache to the queue.
  }

  public static void main(String args[]) {
    LFUCache lfuCache = new LFUCache(3);
    lfuCache.set(2,10);
    lfuCache.set(4,12);
    lfuCache.set(6,14);


    lfuCache.get(6);
    lfuCache.get(2);
    lfuCache.set(8,16);
  }


}