package epi;
import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;
public class DescendantAndAncestorInBst {

  public static boolean
  pairIncludesAncestorAndDescendantOfM(BstNode<Integer> possibleAncOrDesc0,
                                       BstNode<Integer> possibleAncOrDesc1,
                                       BstNode<Integer> middle) {
    // TODO - you fill in here.
    BstNode<Integer> search0 = possibleAncOrDesc0, search1 = possibleAncOrDesc1;
    while (search0 != possibleAncOrDesc1 && search0 != middle
            && search1 != possibleAncOrDesc0 && search1 != middle
            && (search0 != null || search1 != null)) {
      if (search0 != null) {
        search0 = search0.data > middle.data ? search0.left : search0.right;
      }

      if (search1 != null) {
        search1 = search1.data > middle.data ? search1.left : search1.right;
      }
    }

    if (search0 == possibleAncOrDesc1 || search1 == possibleAncOrDesc0 ||
            (search0 != middle && search1 != middle)) {
      return false;
    }


//    return helper(middle, search0 == middle ? possibleAncOrDesc1: possibleAncOrDesc0 );
    return search0 == middle ? helper(middle, possibleAncOrDesc1)
                              : helper(middle, possibleAncOrDesc0);

  }

  private static boolean helper(BstNode<Integer> middle, BstNode<Integer> toNode) {
    while (middle != null && middle != toNode) {
      middle = middle.data > toNode.data ? middle.left : middle.right;

    }
    return middle == toNode;
  }

  @EpiTest(testDataFile = "descendant_and_ancestor_in_bst.tsv")
  public static boolean pairIncludesAncestorAndDescendantOfMWrapper(
      TimedExecutor executor, BstNode<Integer> tree, int possibleAncOrDesc0,
      int possibleAncOrDesc1, int middle) throws Exception {
    final BstNode<Integer> candidate0 =
        BinaryTreeUtils.mustFindNode(tree, possibleAncOrDesc0);
    final BstNode<Integer> candidate1 =
        BinaryTreeUtils.mustFindNode(tree, possibleAncOrDesc1);
    final BstNode<Integer> middleNode =
        BinaryTreeUtils.mustFindNode(tree, middle);

    return executor.run(()
                            -> pairIncludesAncestorAndDescendantOfM(
                                candidate0, candidate1, middleNode));
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DescendantAndAncestorInBst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
