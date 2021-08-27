package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Collections;
import java.util.List;
public class SmallestNonconstructibleValue {
  @EpiTest(testDataFile = "smallest_nonconstructible_value.tsv")

  public static int smallestNonconstructibleValue(List<Integer> A) {
    // TODO - you fill in here.

    Collections.sort(A);
    int num = 0;
    for (int a: A) {
      if (a > num+1) {
        break ;
      }
      else {
        num += a;
      }

    }
    return num+1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SmallestNonconstructibleValue.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
