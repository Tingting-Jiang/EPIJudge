package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;
import epi.test_framework.LexicographicalListComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
public class NQueens {
  @EpiTest(testDataFile = "n_queens.tsv")

  public static List<List<Integer>> nQueens(int n) {
    // TODO - you fill in here.

    List<List<Integer>> ans = new ArrayList<>();

    queensHelper(n, 0, new ArrayList<Integer>(), ans);
    return ans;
  }

  private static void queensHelper(int n, int row, ArrayList<Integer> part, List<List<Integer>> ans) {
    if (row == n) {
      ans.add(new ArrayList<>(part));
    } else {
      for (int col = 0; col < n; col++) {
        part.add(col);
        if (isValid(part)) {
          queensHelper(n, row+1, part, ans);
        }

        part.remove(part.size()-1);


      }
    }
  }

  private static boolean isValid(ArrayList<Integer> part) {
    int rowId = part.size()-1;
    for (int i = 0; i < rowId; i++) {
      int diff = Math.abs(part.get(rowId)- part.get(i));
      if (diff == 0 || diff == rowId - i) {
        return false;
      }
    }
    return true;
  }


  @EpiTestComparator
  public static boolean comp(List<List<Integer>> expected,
                             List<List<Integer>> result) {
    if (result == null) {
      return false;
    }
    expected.sort(new LexicographicalListComparator<>());
    result.sort(new LexicographicalListComparator<>());
    return expected.equals(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NQueens.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
