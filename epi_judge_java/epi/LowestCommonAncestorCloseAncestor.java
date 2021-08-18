package epi;
import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;
public class LowestCommonAncestorCloseAncestor {

  public static BinaryTree<Integer> lca(BinaryTree<Integer> node0,
                                        BinaryTree<Integer> node1) {
    // TODO - you fill in here.
    int depth0 = checkDepth(node0);
    int depth1 = checkDepth(node1);
    if (depth1 > depth0) {
      BinaryTree<Integer> temp = node1;
      node1= node0;
      node0 = temp;
    }
    for (int i = 0; i< Math.abs(depth0 - depth1); i++) {
      node0= node0.parent;
    }

    while(node0!= node1) {
      node0 = node0.parent;
      node1 = node1.parent;
    }
    return node0;

  }

  private static int checkDepth(BinaryTree<Integer> node) {
    int depth = 0;
    while(node != null) {
      node = node.parent;
      depth++;
    }
    return depth;
  }

  @EpiTest(testDataFile = "lowest_common_ancestor.tsv")
  public static int lcaWrapper(TimedExecutor executor, BinaryTree<Integer> tree,
                               Integer key0, Integer key1) throws Exception {
    BinaryTree<Integer> node0 = BinaryTreeUtils.mustFindNode(tree, key0);
    BinaryTree<Integer> node1 = BinaryTreeUtils.mustFindNode(tree, key1);

    BinaryTree<Integer> result = executor.run(() -> lca(node0, node1));

    if (result == null) {
      throw new TestFailure("Result can not be null");
    }
    return result.data;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LowestCommonAncestorCloseAncestor.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
