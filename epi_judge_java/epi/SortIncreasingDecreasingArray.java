package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SortIncreasingDecreasingArray {

  private enum Trend{INCREASE, DECREASE};
  @EpiTest(testDataFile = "sort_increasing_decreasing_array.tsv")

  public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
    // TODO - you fill in here.
    List<List<Integer>> sorted = new ArrayList<>();
    Trend type = Trend.INCREASE;
    int startIdx = 0;
    for (int i = 1; i <= A.size(); i++) {
      if (i == A.size() || A.get(i-1) < A.get(i) && type == Trend.DECREASE ||
      A.get(i-1) >= A.get(i) && type == Trend.INCREASE) {
        List<Integer> subList = A.subList(startIdx, i);
        if (type == Trend.DECREASE) {
          Collections.reverse(subList);
        }
        sorted.add(subList);
        startIdx = i;
        type = type == Trend.DECREASE ? Trend.INCREASE : Trend.DECREASE;
      }

    }

    return SortedArraysMerge.mergeSortedArrays(sorted);

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortIncreasingDecreasingArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
