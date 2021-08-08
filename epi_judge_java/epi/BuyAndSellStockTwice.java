package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class BuyAndSellStockTwice {
  @EpiTest(testDataFile = "buy_and_sell_stock_twice.tsv")
  public static double buyAndSellStockTwice(List<Double> prices) {
    // TODO - you fill in here.
    double maxProfit = 0.0;
    double minPrice = Double.MAX_VALUE;
    List<Double> firstSell = new ArrayList<>();
    for (Double price: prices) {
      minPrice = Math.min(minPrice, price);
      maxProfit = Math.max(maxProfit, price - minPrice);
      firstSell.add(maxProfit);
    }


    double maxPrice = Double.MIN_VALUE;
    for (int i = prices.size()-1; i >0 ; i--) {
      maxPrice = Math.max(maxPrice, prices.get(i));
      maxProfit = Math.max(maxProfit, maxPrice - prices.get(i) + firstSell.get(i));

    }

    // Time: n  Space: n


    return maxProfit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStockTwice.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
