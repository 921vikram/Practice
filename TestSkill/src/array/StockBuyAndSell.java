package array;

public class StockBuyAndSell {


  void stockBuySell(int price[], int n) {
    // Prices must be given for at least two days
    if (n == 1)
      return;
    int minIndex = Integer.MAX_VALUE;
    int profit = 0;
    for (int i = 0; i < n; i++) {
      if (price[i] < minIndex) {
        minIndex = price[i];
      } else {
        int tmp = price[i] - minIndex;
        if (tmp > profit) {
          profit = tmp;
        }
      }
    }
    System.out.println("Profit is " + profit);
  }

  public static void main(String args[]) {
    StockBuyAndSell stock = new StockBuyAndSell();

    // stock prices on consecutive days
    //int price[] = { 100, 180, 260, 310, 40, 535, 695 };
    int price[] = {7, 1, 5, 3, 6, 4};
    int n = price.length;

    // function call
    stock.stockBuySell(price, n);
  }
}
