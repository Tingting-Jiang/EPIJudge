package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class TreeWithParentInorder {
  @EpiTest(testDataFile = "tree_with_parent_inorder.tsv")

  public static List<Integer> inorderTraversal(BinaryTree<Integer> tree) {
    // TODO - you fill in here.
      BinaryTree<Integer> prev = null;
      BinaryTree<Integer> curr = tree;
      List<Integer> ans = new ArrayList<>();
      while(curr != null) {
          BinaryTree<Integer> next;
          if (curr.parent == prev) { // curr is the left child
             if (curr.left != null) {
                 next = curr.left;
             }
             else { // curr is leaf node: back to parent, or it has right child: traverse the right
                 ans.add(curr.data);
                 next = curr.right!= null ? curr.right : curr.parent;
             }
          }

          else if (curr.left == prev) { // curr is the root, next traverse the right child
              ans.add(curr.data);
              if (curr.right != null) {
                  next = curr.right;
              } else {
                  next = curr.parent;
              }

          } else { //curr is the right child
              next = curr.parent;

          }

          prev = curr;
          curr = next;


      }
      return ans;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeWithParentInorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
