package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
public class TreeInorder {

//  private static class NodeAndState {
//    public BinaryTreeNode<Integer> node;
//    public Boolean leftSubtreeTraversed;
//
//    public NodeAndState(BinaryTreeNode<Integer> node,
//                        Boolean leftSubtreeTraversed) {
//      this.node = node;
//      this.leftSubtreeTraversed = leftSubtreeTraversed;
//    }
//  }

  @EpiTest(testDataFile = "tree_inorder.tsv")
  public static List<Integer> inorderTraversal(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.
//    Deque<NodeAndState> stack = new ArrayDeque<>();
//    stack.addFirst(new NodeAndState(tree, false));
//    List<Integer> ans = new ArrayList<>();
//    while (!stack.isEmpty()) {
//      NodeAndState node = stack.removeFirst();
//      if (node.node != null) {
//        if (node.leftSubtreeTraversed) {
//          ans.add(node.node.data);
//        } else {
//          stack.addFirst(new NodeAndState(node.node.right, false));
//          stack.addFirst(new NodeAndState(node.node, true));
//          stack.addFirst(new NodeAndState(node.node.left, false));
//        }
//      }
//    }
//    return ans;

    List<Integer> ans = new ArrayList<>();
    Deque<BinaryTreeNode<Integer>> stack = new ArrayDeque<>();
    BinaryTreeNode<Integer> curr = tree;

    while(curr != null || !stack.isEmpty()) {
      while(curr != null) {
        stack.addFirst(curr);
        curr = curr.left;
      }
      curr = stack.removeFirst();
      ans.add(curr.data);
      curr = curr.right;
    }
    return ans;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeInorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
