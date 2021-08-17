package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeBalanced {


  private int height;
  private boolean isBalanced;

  public IsTreeBalanced(int height, boolean isBalanced) {
    this.height = height;
    this.isBalanced = isBalanced;
  }

  @EpiTest(testDataFile = "is_tree_balanced.tsv")
  public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.
    return checkBalance(tree).isBalanced;
  }

  private static IsTreeBalanced checkBalance(BinaryTreeNode<Integer> tree) {
    if (tree == null) {
      return new IsTreeBalanced(-1, true);
    }

    IsTreeBalanced leftResult = checkBalance(tree.left);
    if (!leftResult.isBalanced) {
      return leftResult;
    }

    IsTreeBalanced rightResult = checkBalance(tree.right);
    if (!rightResult.isBalanced) {
      return rightResult;
    }

    int treeHeight = Math.max(leftResult.height, rightResult.height) +1;
    boolean treeBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
    return new IsTreeBalanced(treeHeight, treeBalanced);


    // postOrder traversal with O(n) time and O(h) space
  }



  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeBalanced.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
