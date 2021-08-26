package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubarrayWithDistinctValues {
  @EpiTest(testDataFile = "longest_subarray_with_distinct_values.tsv")

  public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
    // TODO - you fill in here.
    Map<Integer, Integer> dic = new HashMap<>();
    int longestStart= 0, result = 0;
    for (int i = 0; i < A.size(); ++i) {
      Integer dupIdx = dic.put(A.get(i), i); // get the last index
      if (dupIdx != null) {
        if (dupIdx >= longestStart) {
          result = Math.max(result, i - longestStart);
          longestStart = dupIdx+1;
        }
      }

    }

    return Math.max(result, A.size() - longestStart);



  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LongestSubarrayWithDistinctValues.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
