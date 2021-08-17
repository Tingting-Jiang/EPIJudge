package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeSymmetric {
  @EpiTest(testDataFile = "is_tree_symmetric.tsv")

  public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.
    if (tree == null) return true;
    return checkHelper(tree.left, tree.right);

  }

  private static boolean checkHelper(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
    if (left == null && right == null) {
      return true;
    }
    else if ((left== null && right != null) || (left != null && right == null)) {
      return false;
    }
    return left.data == right.data && checkHelper(left.left, right.right) && checkHelper(left.right, right.left);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeSymmetric.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
