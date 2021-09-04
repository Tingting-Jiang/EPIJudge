package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class BinomialCoefficients {
  @EpiTest(testDataFile = "binomial_coefficients.tsv")

  public static int computeBinomialCoefficient(int n, int k) {
    // TODO - you fill in here.
    return coefficientHelper(n, k, new int[n+1][k+1]);

  }

  private static int coefficientHelper(int totalNum, int choose, int[][] ints) {
    if (choose == 0 || totalNum == choose) return 1;
    if (ints[totalNum][choose] == 0) {
      int with = coefficientHelper(totalNum-1, choose-1,ints);
      int without = coefficientHelper(totalNum-1, choose, ints);
      ints[totalNum][choose] = with + without;
    }
    return ints[totalNum][choose];
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BinomialCoefficients.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
