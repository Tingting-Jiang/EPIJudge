package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
public class KLargestValuesInBst {
  @EpiTest(testDataFile = "k_largest_values_in_bst.tsv")

  public static List<Integer> findKLargestInBst(BstNode<Integer> tree, int k) {
    // TODO - you fill in here.
    List<Integer> ans = new ArrayList<>();
    findHelper(tree, ans, k);
    return ans;


  }

  private static void findHelper(BstNode<Integer> tree, List<Integer> ans, int k) {
    if (tree != null && k > ans.size()) {
      findHelper(tree.right, ans, k);
      if (ans.size() < k) {
        ans.add(tree.data); // if the right child is not enough, add the tree itself and its left child
        findHelper(tree.left, ans, k);
      }
    }
  }

  @EpiTestComparator
  public static boolean comp(List<Integer> expected, List<Integer> result) {
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
            .runFromAnnotations(args, "KLargestValuesInBst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
