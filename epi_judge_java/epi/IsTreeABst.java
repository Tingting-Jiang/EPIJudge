package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeABst {
  @EpiTest(testDataFile = "is_tree_a_bst.tsv")

  public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.
    int upper = Integer.MAX_VALUE;
    int lower = Integer.MIN_VALUE;
    return helper(tree, upper, lower);

  }

  private static boolean helper(BinaryTreeNode<Integer> tree, int upper, int lower) {
    if (tree == null) return true;
    if (tree.data < lower || tree.data > upper) return false;
    return helper(tree.left, tree.data, lower) && helper(tree.right, upper, tree.data);


  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeABst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
