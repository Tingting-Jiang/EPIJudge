package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class TreeLevelOrder {
  @EpiTest(testDataFile = "tree_level_order.tsv")

  public static List<List<Integer>>
  binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.
    Deque<BinaryTreeNode<Integer>> queue = new ArrayDeque<>();
    List<List<Integer>> ans = new ArrayList<>();
    if (tree == null) return Collections.emptyList();
    queue.add(tree);

    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int length = queue.size();
      for (int i = 0; i< length; i++ ) {
        BinaryTreeNode<Integer> node = queue.removeFirst();
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        level.add(node.data);
      }
      ans.add(level);

      }
    return ans;


    }


  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeLevelOrder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
