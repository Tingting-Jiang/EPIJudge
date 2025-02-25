package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class SearchRowColSortedMatrix {
  @EpiTest(testDataFile = "search_row_col_sorted_matrix.tsv")

  public static boolean matrixSearch(List<List<Integer>> A, int x) {
    // TODO - you fill in here.
    if (x < A.get(0).get(0)) return false;
    int row = 0, col = A.get(0).size()-1;
    while (row <A.size() && col >=0) {
      if (A.get(row).get(col) >x) {
        col --;
      } else if (A.get(row).get(col) < x) {
        row ++;
      } else {
        return true;
      }
    }
    return false;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchRowColSortedMatrix.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
