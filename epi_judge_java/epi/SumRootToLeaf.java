package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SumRootToLeaf {
  @EpiTest(testDataFile = "sum_root_to_leaf.tsv")

  public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.
    return sumHelper(tree, 0);

  }

  private static int sumHelper(BinaryTreeNode<Integer> tree, int partialSum) {
    if (tree == null) return 0;
    partialSum = partialSum * 2 + tree.data;
    if (tree.left == null && tree.right == null) return partialSum;
    return sumHelper(tree.left, partialSum) + sumHelper(tree.right, partialSum);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SumRootToLeaf.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
