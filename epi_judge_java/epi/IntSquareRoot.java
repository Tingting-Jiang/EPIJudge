package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IntSquareRoot {
  @EpiTest(testDataFile = "int_square_root.tsv")

  public static int squareRoot(int k) {
    // TODO - you fill in here.
    int left = 0, right = k;
    while (left <= right) {
      long mid = left + (right - left)/2;
      long pro = mid * mid;
      if (pro > k) {
        right = (int) (mid -1);
      } else {
        left = (int) (mid +1);
      }
    }
    return (int) left -1;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntSquareRoot.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
