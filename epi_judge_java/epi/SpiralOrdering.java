package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class SpiralOrdering {
  @EpiTest(testDataFile = "spiral_ordering.tsv")

  public static List<Integer>
  matrixInSpiralOrder(List<List<Integer>> A) {
    // TODO - you fill in here.
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < Math.ceil(0.5 * A.size()); i++) {
      matrixHelper(A,res,i);
    }

    return res;
  }

  private static void matrixHelper(List<List<Integer>> A, List<Integer> res, int offset) {
    if (offset == A.size() - offset - 1) {
      res.add(A.get(offset).get(offset));
      return;
    }

    // top
    for (int i = offset; i <A.size() - 1 - offset ; i++) {
      res.add(A.get(offset).get(i));
    }

    // right
    for (int j = offset; j < A.size() - 1 - offset; j++) {
      res.add(A.get(j).get(A.size() - 1 - offset));

    }

    // bottom
    for (int k = A.size()- offset - 1; k > offset  ; k--) {
      res.add(A.get(A.size()- offset - 1).get(k));

    }

    // left
    for (int m = A.size()- offset - 1; m > offset  ; m--) {
      res.add(A.get(m).get(offset));

    }



  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SpiralOrdering.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
