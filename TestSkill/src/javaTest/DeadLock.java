package javaTest;

public class DeadLock {

  public static void main(String[] args) {

    Object bowl = new Object();
    Object spoon = new Object();


    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (bowl) {
          System.out.println("Thread 1 Inside bowl");

          synchronized(spoon) {
            System.out.println("Thread 1 Inside spoon");
          }

        }
      }
    });


    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (spoon) {
          System.out.println("Thread 2 Inside spoon");

          synchronized(bowl) {
            System.out.println("Thread 2 Inside bowl");
          }

        }
      }
    });

    thread1.start();
    thread2.start();

  }

}
