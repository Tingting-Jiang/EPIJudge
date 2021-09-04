package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class NumberOfTraversalsMatrix {
  @EpiTest(testDataFile = "number_of_traversals_matrix.tsv")

  public static int numberOfWays(int n, int m) {
    // TODO - you fill in here.

    return waysHelper(n-1, m-1, new int[n][m]);
  }

  private static int waysHelper(int row, int col, int[][] ints) {
    if (row == 0 && col == 0) {
      return 1;
    }
    if (ints[row][col] == 0) {
      int waysTop = row == 0? 0: waysHelper(row-1, col, ints);
      int waysLeft = col == 0? 0: waysHelper(row, col-1, ints);
      ints[row][col] = waysLeft + waysTop;
    }
    return ints[row][col];
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NumberOfTraversalsMatrix.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
