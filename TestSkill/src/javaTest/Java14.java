package javaTest;

import java.io.IOException;

public class Java14 {

  public static void main(String args[]) {
    Object r = "";
    if( r instanceof String s) {
      System.out.println("length " +s.length());
    }

    record Point(int x, int y) {};
    Point p = new Point(2,3);
    System.out.println("x "+p.x);

    // get the current runtime assosiated with this process
    Runtime run = Runtime.getRuntime();
    // print the current free memory for this runtime
    System.out.println("Memory " + run.freeMemory());
    System.out.println("Processor " + run.availableProcessors());
    try {
      Process process = run.exec("ls");

    } catch (IOException e) {
      e.printStackTrace();
    }

    // cause the program to exit
    Runtime.getRuntime().exit(0);

    //Nothing will run now.
    System.out.println("Program Running Check");
  }
}
