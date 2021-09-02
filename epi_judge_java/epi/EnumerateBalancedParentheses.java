package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
public class EnumerateBalancedParentheses {
  @EpiTest(testDataFile = "enumerate_balanced_parentheses.tsv")

  public static List<String> generateBalancedParentheses(int numPairs) {
    // TODO - you fill in here.

    List<String> ans = new ArrayList<>();
    parentheseHelper(numPairs, numPairs, ans, "");
    return ans;
  }

  private static void parentheseHelper(int leftNum, int rightNum, List<String> ans, String prefix) {
    if(rightNum == 0) {
      ans.add(prefix);
      return;
    }
    if (leftNum > 0) {
      parentheseHelper(leftNum-1, rightNum, ans, prefix+"(");
    }
    if (leftNum < rightNum) {
      parentheseHelper(leftNum, rightNum-1, ans, prefix+")");
    }
   }

  @EpiTestComparator
  public static boolean comp(List<String> expected, List<String> result) {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    return expected.equals(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EnumerateBalancedParentheses.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
