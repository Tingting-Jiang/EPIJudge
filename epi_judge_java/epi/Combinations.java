package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;
import epi.test_framework.LexicographicalListComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
public class Combinations {
  @EpiTest(testDataFile = "combinations.tsv")

  public static List<List<Integer>> combinations(int n, int k) {
    // TODO - you fill in here.
    List<List<Integer>> ans = new ArrayList<>();
    combineHelper(n, k, 1, new ArrayList<Integer>(), ans);


    return ans;
  }

  private static void combineHelper(int n, int k, int offset, ArrayList<Integer> combinations, List<List<Integer>> ans) {

    if (combinations.size() == k) {
      ans.add(new ArrayList<>(combinations));
      return;
    }
    final int remain = k - combinations.size();
    for (int j = offset; j <= n && remain <= n-j+1; j++) {
     combinations.add(j);
      combineHelper(n, k, j+1, combinations, ans);
      combinations.remove(combinations.size()-1);

    }

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
            .runFromAnnotations(args, "Combinations.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
