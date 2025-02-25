package epi;
import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;
public class LowestCommonAncestorInBst {

  // Input nodes are nonempty and the key at s is less than or equal to that at
  // b.
  public static BstNode<Integer>
  findLca(BstNode<Integer> tree, BstNode<Integer> s, BstNode<Integer> b) {
    // TODO - you fill in here.
    // if tree is less than the s, search the right children
//    while (tree != null) {
//      if (tree.data < s.data) {
//        tree = tree.right;
//      } else if (tree.data > b.data) {
//        tree = tree.left;
//      } else {
//        return tree;
//      }
//    }
//    return null;
    BstNode<Integer> p = tree;
    while (p.data < s.data || p.data> b.data) {
      while (p.data < s.data) {
        p = p.right;
      }
      while (p.data > b.data) {
        p = p.left;
      }
    }
    return p;
  }
  @EpiTest(testDataFile = "lowest_common_ancestor_in_bst.tsv")
  public static int lcaWrapper(TimedExecutor executor, BstNode<Integer> tree,
                               Integer key0, Integer key1) throws Exception {
    BstNode<Integer> node0 = BinaryTreeUtils.mustFindNode(tree, key0);
    BstNode<Integer> node1 = BinaryTreeUtils.mustFindNode(tree, key1);

    BstNode<Integer> result = executor.run(() -> findLca(tree, node0, node1));

    if (result == null) {
      throw new TestFailure("Result can't be null");
    }
    return result.data;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LowestCommonAncestorInBst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
