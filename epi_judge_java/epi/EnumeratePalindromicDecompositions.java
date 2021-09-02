package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;
import epi.test_framework.LexicographicalListComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
public class EnumeratePalindromicDecompositions {
  @EpiTest(testDataFile = "enumerate_palindromic_decompositions.tsv")

  public static List<List<String>> palindromeDecompositions(String text) {
    // TODO - you fill in here.
    List<List<String>> ans = new ArrayList<>();
    decomposeHelper(text, 0, new ArrayList<String>(), ans);
    return ans;
  }

  private static void decomposeHelper(String text, int offset, ArrayList<String> strings, List<List<String>> ans) {
    if (offset == text.length()) {
      ans.add(new ArrayList<>(strings));
      return;
    }

    for (int i = offset+1; i <= text.length(); i++) {
     String prefix = text.substring(offset,i);
      if (isValid(prefix)) {
        strings.add(prefix);
        decomposeHelper(text, i, strings, ans);
        strings.remove(strings.size()-1);
      }


    }
  }


  private static boolean isValid(String prefix) {
    for (int left = 0, right = prefix.length()-1; left< right; ++left, --right) {
      if (prefix.charAt(left)!= prefix.charAt(right)) {
        return false;
      }

    }
    return true;
  }

  @EpiTestComparator
  public static boolean comp(List<List<String>> expected,
                             List<List<String>> result) {
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
            .runFromAnnotations(args, "EnumeratePalindromicDecompositions.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
