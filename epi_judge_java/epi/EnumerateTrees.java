package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.LexicographicalListComparator;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
public class EnumerateTrees {

  public static List<BinaryTreeNode<Integer>>
  generateAllBinaryTrees(int numNodes) {
    // TODO - you fill in here.

    List<BinaryTreeNode<Integer>> ans = new ArrayList<>();
    if (numNodes == 0) {
      ans.add(null);
    }

    for (int left = 0; left < numNodes; left++) {
      int right = numNodes - left -1;
      List<BinaryTreeNode<Integer>> leftTree = generateAllBinaryTrees(left);
      List<BinaryTreeNode<Integer>> rightTree = generateAllBinaryTrees(right);
      for (BinaryTreeNode<Integer> leftSub: leftTree) {
        for (BinaryTreeNode<Integer> rightSub: rightTree) {
          ans.add(new BinaryTreeNode<>(0, leftSub, rightSub));

        }

      }
    }

    return ans;
  }
  public static List<Integer> serializeStructure(BinaryTreeNode<Integer> tree) {
    List<Integer> result = new ArrayList<>();
    Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
    stack.push(tree);
    while (!stack.empty()) {
      BinaryTreeNode<Integer> p = stack.pop();
      result.add(p == null ? 0 : 1);
      if (p != null) {
        stack.push(p.left);
        stack.push(p.right);
      }
    }
    return result;
  }

  @EpiTest(testDataFile = "enumerate_trees.tsv")
  public static List<List<Integer>>
  generateAllBinaryTreesWrapper(TimedExecutor executor, int numNodes)
      throws Exception {
    List<BinaryTreeNode<Integer>> result =
        executor.run(() -> generateAllBinaryTrees(numNodes));

    List<List<Integer>> serialized = new ArrayList<>();
    for (BinaryTreeNode<Integer> x : result) {
      serialized.add(serializeStructure(x));
    }
    serialized.sort(new LexicographicalListComparator<>());
    return serialized;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EnumerateTrees.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
