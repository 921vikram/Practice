package javaTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTest {

  public static void main(String args[]) throws InterruptedException {
    BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);

    queue.put("vik");
    queue.put("pra");
    queue.remove();
    queue.put("neh");



  }
}
