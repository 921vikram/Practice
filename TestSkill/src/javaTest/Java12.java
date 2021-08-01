package javaTest;

public class Java12 {

  public static void main(String args[]) {
    //java 12 Switch redesign

    String month = "FEB";
    int year = 2020;

    int ndays = switch(month) {
      case "JAN", "MAR", "MAY", "JUL", "AUG", "OCT", "DEC" -> 31;
      case "APR", "JUN", "SEP", "NOV" -> 30;
      case "FEB" -> {
        if (year % 400 ==0) yield 29;
        else if (year % 100 == 0) yield 28;
        else if (year % 4 ==0) yield 29;
        else yield 28; }
      default -> throw new IllegalStateException("Unexpected value: " + month);
    };

    System.out.println("days "+ndays);

  }
}
