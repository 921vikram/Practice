package javaTest;

import java.util.Random;
import java.util.concurrent.Callable;

class CallableExample implements Callable
{

  public Object call() throws Exception
  {
    Random generator = new Random();
    Integer randomNumber = generator.nextInt(5);
    System.out.println("Name " +Thread.currentThread().getName()+" value "+randomNumber+ " Time "+System.currentTimeMillis());
    Thread.sleep(randomNumber * 1000);
    System.out.println("Name " +Thread.currentThread().getName()+" value "+randomNumber+ " Time "+System.currentTimeMillis());
    return randomNumber;
  }

}