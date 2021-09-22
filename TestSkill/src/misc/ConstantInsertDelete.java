package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ConstantInsertDelete {

  ArrayList<Integer> arr;
  HashMap<Integer, Integer> hash;

  public ConstantInsertDelete() {
    this.arr = new ArrayList<>();
    this.hash = new HashMap<>();
  }

  void add(int x) {
    Integer a = hash.get(x);
    if(null != a) {
      return;
    }
    int size = arr.size();
    arr.add(x);
    hash.put(x,size);
  }

  void remove(int x) {
    Integer a = hash.get(x);
    if(null == a) {
      return;
    }
    arr.set(a, arr.get(arr.size() -1));
    hash.put(arr.get(arr.size() -1), a);
    hash.remove(x);
    arr.remove(arr.size() -1);
  }

  int getRandom()
  {
    // Find a random index from 0 to size - 1
    Random rand = new Random();  // Choose a different seed
    int index = rand.nextInt(arr.size());

    // Return element at randomly picked index
    return arr.get(index);
  }

  // Returns index of element if element is present, otherwise null
  Integer search(int x)
  {
    return hash.get(x);
  }

  public static void main (String[] args)
  {
    ConstantInsertDelete ds = new ConstantInsertDelete();
    ds.add(10);
    ds.add(20);
    ds.add(30);
    ds.add(40);
    System.out.println(ds.search(30));
    ds.remove(20);
    ds.add(50);
    System.out.println(ds.search(50));
    System.out.println(ds.getRandom());
  }

}
