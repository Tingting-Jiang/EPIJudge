package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestContainedInterval {
  @EpiTest(testDataFile = "longest_contained_interval.tsv")

  public static int longestContainedRange(List<Integer> A) {
    // TODO - you fill in here.
    Set<Integer> dic = new HashSet<>(A);
    int maxSize = 0;

    while (!dic.isEmpty()) {
      int num = dic.iterator().next();
      dic.remove(num);

      int lowBound = num -1;
      while (dic.contains(lowBound)) {
        dic.remove(lowBound);
        lowBound--;
      }

      int upBound = num +1;
      while (dic.contains(upBound)) {
        dic.remove(upBound);
        upBound++;
      }

      maxSize = Math.max(maxSize, upBound - lowBound - 1);
    }

    return maxSize;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LongestContainedInterval.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
