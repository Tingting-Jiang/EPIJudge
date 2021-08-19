package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class TreeExterior {

  public static List<BinaryTreeNode<Integer>>
  exteriorBinaryTree(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.

    if (tree == null) return Collections.emptyList();
    List<BinaryTreeNode<Integer>> ans = new ArrayList<>();
    ans.add(tree);

    leftExterior(tree.left, ans);
    addLeaves(tree.left, ans);
    addLeaves(tree.right, ans);
    rightExterior(tree.right, ans);

    return ans;


  }

  private static void rightExterior(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> ans) {
    if (tree == null || tree.left == null && tree.right == null) return;

    if (tree.right != null) {
      rightExterior(tree.right, ans);
    } else {
      rightExterior(tree.left, ans);
    }
    ans.add(tree);

  }

  private static void addLeaves(BinaryTreeNode<Integer> root, List<BinaryTreeNode<Integer>> ans) {
    if (root != null) {
      if (root.right == null && root.left == null) {
        ans.add(root);
      } else{
        addLeaves(root.left, ans);
        addLeaves(root.right, ans);
      }
    }
  }

  private static void leftExterior(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> ans) {
    if (tree == null || tree.left == null && tree.right == null) return;
    ans.add(tree);
    if (tree.left!= null) {
      leftExterior(tree.left, ans);
    } else {
      leftExterior(tree.right, ans);
    }
  }






  private static List<Integer> createOutputList(List<BinaryTreeNode<Integer>> L)
      throws TestFailure {
    if (L.contains(null)) {
      throw new TestFailure("Resulting list contains null");
    }
    List<Integer> output = new ArrayList<>();
    for (BinaryTreeNode<Integer> l : L) {
      output.add(l.data);
    }
    return output;
  }

  @EpiTest(testDataFile = "tree_exterior.tsv")
  public static List<Integer>
  exteriorBinaryTreeWrapper(TimedExecutor executor,
                            BinaryTreeNode<Integer> tree) throws Exception {
    List<BinaryTreeNode<Integer>> result =
        executor.run(() -> exteriorBinaryTree(tree));

    return createOutputList(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeExterior.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
