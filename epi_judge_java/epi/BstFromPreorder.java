package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class BstFromPreorder {
  private static int rootIdx;
  @EpiTest(testDataFile = "bst_from_preorder.tsv")

//  public static BstNode<Integer>
//  rebuildBSTFromPreorder(List<Integer> preorderSequence) {
//    // TODO - you fill in here.
//
//    return rebuildHelper(preorderSequence, 0, preorderSequence.size());
//
//  }
//
//  private static BstNode<Integer> rebuildHelper(List<Integer> preorderSequence, int start, int end) {
//    if (start >= end) return null;
//    int trans = start + 1;
//    while (trans < end && preorderSequence.get(trans) < preorderSequence.get(start) ) {
//      trans++;
//    }
//    return new BstNode<>(preorderSequence.get(start),
//            rebuildHelper(preorderSequence, start+1, trans),
//            rebuildHelper(preorderSequence, trans, end));
//
//  }


  public static BstNode<Integer>
  rebuildBSTFromPreorder(List<Integer> preorderSequence) {
    rootIdx = 0;
    return rebuildHelper(preorderSequence,Integer.MAX_VALUE, Integer.MIN_VALUE);
  }

  private static BstNode<Integer> rebuildHelper(List<Integer> preorderSequence, int upper, int lower) {
    if (rootIdx == preorderSequence.size()) return null;
    int rootVal = preorderSequence.get(rootIdx);
    if (rootVal> upper || rootVal < lower) return null;

    rootIdx++;
    BstNode<Integer> left = rebuildHelper(preorderSequence, rootVal, lower);
    BstNode<Integer> right = rebuildHelper(preorderSequence, upper, rootVal);

    return new BstNode<>(rootVal, left, right);


  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BstFromPreorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
