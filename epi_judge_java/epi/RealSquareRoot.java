package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class RealSquareRoot {
  @EpiTest(testDataFile = "real_square_root.tsv")

  public static double squareRoot(double x) {
    // TODO - you fill in here.
    double left, right;
    if (x < 1) {
      left = x;
      right = 1;
    }
    else {
      right = x;
      left = 1;
    }

    while (ordering(left, right) != Order.EQUAL) {
      double mid = left + (right - left)* 0.5;
      double pro = mid * mid;

      if (ordering(pro,x) == Order.GREATER) {
        right = mid;
      } else {
        left = mid;
      }
    }

    return left;
  }

  private enum Order{SMALLER, EQUAL, GREATER}

  private static Order ordering (double a, double b) {
    final double EPSILON = 0.000001;
    double dif = (a-b)/Math.max(Math.abs(a), Math.abs(b));
    return dif < -EPSILON ? Order.SMALLER : (dif > EPSILON ? Order.GREATER : Order.EQUAL);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RealSquareRoot.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
