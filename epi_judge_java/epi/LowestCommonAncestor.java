package epi;
import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;
public class LowestCommonAncestor {
  private int num;
  private BinaryTreeNode<Integer> node;

  public LowestCommonAncestor(int num, BinaryTreeNode<Integer> node) {
    this.num = num;
    this.node = node;
  }

  public static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> tree,
                                            BinaryTreeNode<Integer> node0,
                                            BinaryTreeNode<Integer> node1) {
    // TODO - you fill in here.

    return lcaHelper(tree, node0, node1).node;

  }

  private static LowestCommonAncestor lcaHelper(BinaryTreeNode<Integer> tree,
                                                   BinaryTreeNode<Integer> node0,
                                                   BinaryTreeNode<Integer> node1) {

    if (tree == null) return new LowestCommonAncestor(0, null);
    LowestCommonAncestor left = lcaHelper(tree.left,node0, node1);
    if (left.num == 2) return left;
    LowestCommonAncestor right = lcaHelper(tree.right, node0, node1);
    if (right.num == 2) return right;

    int newNum = left.num + right.num + (tree == node0 ? 1: 0) + (tree == node1 ? 1:0);

    return new LowestCommonAncestor(newNum, newNum == 2 ? tree: null);



  }

  @EpiTest(testDataFile = "lowest_common_ancestor.tsv")
  public static int lcaWrapper(TimedExecutor executor,
                               BinaryTreeNode<Integer> tree, Integer key0,
                               Integer key1) throws Exception {
    BinaryTreeNode<Integer> node0 = BinaryTreeUtils.mustFindNode(tree, key0);
    BinaryTreeNode<Integer> node1 = BinaryTreeUtils.mustFindNode(tree, key1);

    BinaryTreeNode<Integer> result =
        executor.run(() -> lca(tree, node0, node1));

    if (result == null) {
      throw new TestFailure("Result can not be null");
    }
    return result.data;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LowestCommonAncestor.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
