package test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StatisticsCalculatorDriver {

  public static void main(String[] args) {
    Statistic statisticCalculator = new StatisticsCalculator();

    ExecutorService threadPool = Executors.newFixedThreadPool(10);
    for (int i = 1; i <= 1000000; i++) {
      threadPool.execute(new Runnable() {
        public void run() {
          Random generator = new Random();
          Integer randomNumber = generator.nextInt(10);
          statisticCalculator.event(randomNumber);
        }
      });
    }
    threadPool.shutdown();
    // Wait until all threads are finish
    while (!threadPool.isTerminated()) {
    }
    System.out.println("Finished all threads");
  }

}
