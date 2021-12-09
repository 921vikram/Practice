//package test;
//
//import java.math.BigDecimal;
//import java.util.*;
//import java.util.stream.Stream;
//
///**
// * abcbad
// * largest sub string which is palindrome
// * <p>
// * abcbad
// * <p>
// * dabcba
// */
//public class Test1 {
//
//  private static class SimpleSoldProduct {
//
//    List<SimpleSoldProduct> products;
//
//
//
//    public List<SimpleSoldProduct> getProducts() {
//      return products;
//    }
//
//    public void setProducts(List<SimpleSoldProduct> products) {
//      this.products = products;
//    }
//
//    public BigDecimal getTotal() {
//      return total;
//    }
//
//    public void setTotal(BigDecimal total) {
//      this.total = total;
//    }
//
//    BigDecimal total;
//
//
//
//
//    private String name;
//    private BigDecimal price;
//
//    public String getName() {
//      return name;
//    }
//
//    public void setName(String name) {
//      this.name = name;
//    }
//
//    public BigDecimal getPrice() {
//      return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//      this.price = price;
//    }
//  }
//    private static class SoldProduct {
//    private String name;
//    private BigDecimal price;
//    private String currency;
//
//
//    public SoldProduct(String name, BigDecimal price, String currency) {
//      this.name = name;
//      this.price = price;
//      this.currency = currency;
//    }
//
//    @Override
//    public String toString() {
//      return "SoldProduct{" +
//        "name='" + name + '\'' +
//        ", price=" + price +
//        ", currency='" + currency + '\'' +
//        '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//      if (this == o) return true;
//      if (o == null || getClass() != o.getClass()) return false;
//      SoldProduct that = (SoldProduct) o;
//      return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(currency, that.currency);
//    }
//
//    @Override
//    public int hashCode() {
//      return Objects.hash(name, price, currency);
//    }
//
//    public String getName() {
//      return name;
//    }
//
//    public void setName(String name) {
//      this.name = name;
//    }
//
//    public BigDecimal getPrice() {
//      return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//      this.price = price;
//    }
//
//    public String getCurrency() {
//      return currency;
//    }
//
//    public void setCurrency(String currency) {
//      this.currency = currency;
//    }
//  }
//
//  public static void main(String args[]) {
//    Stream<SimpleSoldProduct> products = Stream.empty();
//
//    List<SoldProduct> l = new ArrayList<>();
//
//    //Arrays.stream(products).forEach(q -> );
//
//    products.forEach(a ->  {
//      a.getName();
//      SoldProduct soldProduct = new SoldProduct("");
//      l.add(soldProduct);
//
//    });
//
//    Scanner sc = new Scanner(System.in);
//    int len = sc.nextInt();
//    int[] arr = new int[len];
//    for(int i =0; i < len; i++) {
//      arr[i] = sc.nextInt();
//    }
//    int total = 0;
//
//
//
//    String a = "abcbad";
//    char[] a1 = a.toCharArray();
//    len = findLongestSubstring(a1);
//    System.out.println(" longenst lenght : " + len);
//  }
//
//  private static int findLongestSubstring(char[] arr) {
//
//    int n = arr.length;
//    boolean[][] dp = new boolean[n + 1][n + 1];
//    int maxLength = 0;
//
//    // Conditions
//    // 1. boundary should match
//    // 2. also sub problem will be palindrome dp[i+1][j-1]
//
//    for (int i = 0; i < n; i++) {
//      dp[i][i] = true;
//    }
//
//    // 2 length substring
//    for (int i = 0; i < n - 2; i++) {
//      if (arr[i] == arr[i + 1]) {
//        dp[i][i + 1] = true;
//      }
//    }
//
//    for (int i = 0; i < n; i++) {
//      for (int j = 2; j < n; j++) {
//        if (arr[i] == arr[j] || dp[i + 1][j - 1]) {
//          maxLength = Math.max(maxLength, j-i+1);
//          dp[i][j] = true;
//        }
//      }
//    }
//
//    return maxLength;
//
////    int maxLength = 0;
////    for (int i = 1; i < arr.length - 1; i++) {
////      // for each i we will find longest palindrome
////      int tmpLength = getLengthOfPalindrome(arr, i);
////      maxLength = Math.max(tmpLength, maxLength);
////    }
////    return maxLength;
//  }
//
//
////  private static int getLengthOfPalindrome(char[] arr, int m) {
////    int length = 0;
////    int i = m - 1;
////    int j = m + 1;
////    int n = arr.length;
////    while (i >= 0 && j <= n - 1) {
////      if (arr[i] != arr[j]) {
////        return length;
////      } else {
////        length = +2;
////      }
////      i--;
////      j++;
////    }
////    return length;
////  }
//
//
//}
