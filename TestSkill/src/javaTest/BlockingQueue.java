package javaTest;

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

class BlockingQueue<E> {

  // BlockingQueue using LinkedList structure
  // with a constraint on capacity
  private List<E> queue = new LinkedList<E>();

  // limit variable to define capacity
  private int limit = 10;

  // constructor of BlockingQueue
  public BlockingQueue(int limit) { this.limit = limit; }

  // enqueue method that throws Exception
  // when you try to insert after the limit
  public synchronized void enqueue(E item)
    throws InterruptedException
  {
    while (this.queue.size() == this.limit) {
      wait();
    }
    if (this.queue.size() == 0) {
      notifyAll();
    }
    this.queue.add(item);
  }

  // dequeue methods that throws Exception
  // when you try to remove element from an
  // empty queue
  public synchronized E dequeue()
    throws InterruptedException
  {
    while (this.queue.size() == 0) {
      wait();
    }
    if (this.queue.size() == this.limit) {
      notifyAll();
    }

    return this.queue.remove(0);
  }

  @Override
  public String toString() {
    return "BlockingQueue{" +
      "queue=" + queue +
      ", limit=" + limit +
      '}';
  }

  public static void main(String []args) throws InterruptedException {
    // define capacity of ArrayBlockingQueue
    int capacity = 5;

    // create object of ArrayBlockingQueue
    BlockingQueue<String> queue
      = new BlockingQueue<String>(capacity);

    // Add elements to ArrayBlockingQueue using put
    // method
    queue.enqueue("StarWars");
    queue.enqueue("SuperMan");
    queue.enqueue("Flash");
    queue.enqueue("BatMan");
    queue.enqueue("Avengers");

    // print Queue
    System.out.println("queue contains " + queue);

    // remove some elements
    queue.dequeue();
    queue.dequeue();

    // Add elements to ArrayBlockingQueue
    // using put method
    queue.enqueue("CaptainAmerica");
    queue.enqueue("Thor");
    queue.enqueue("Thor1");

    System.out.println("queue contains " + queue);
  }
}