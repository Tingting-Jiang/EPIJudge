package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;

import java.awt.image.WritableRenderedImage;
import java.util.Arrays;
import java.util.List;
public class Knapsack {
  @EpiUserType(ctorParams = {Integer.class, Integer.class})

  public static class Item {
    public Integer weight;
    public Integer value;

    public Item(Integer weight, Integer value) {
      this.weight = weight;
      this.value = value;
    }
  }

  @EpiTest(testDataFile = "knapsack.tsv")

  public static int optimumSubjectToCapacity(List<Item> items, int capacity) {
    // TODO - you fill in here.
    int [][] table = new int[items.size()][capacity+1];
    for(int [] row : table) {
      Arrays.fill(row, -1);
    }
    return backpackHelper(items, items.size()-1, capacity, table);
  }

  private static int backpackHelper(List<Item> items, int numOfItems, int capacity, int[][] table) {
    if (numOfItems < 0) return 0;

    if (table[numOfItems][capacity] == -1) {
      int weight = items.get(numOfItems).weight;
      int withItem = weight > capacity? 0 : items.get(numOfItems).value+
              backpackHelper(items, numOfItems-1, capacity - weight, table );
      int withoutItem = backpackHelper(items, numOfItems-1, capacity, table);
      table[numOfItems][capacity] = Math.max(withItem, withoutItem);
    }
    return table[numOfItems][capacity];
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Knapsack.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
