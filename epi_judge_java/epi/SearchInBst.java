package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SearchInBst {

  public static BstNode<Integer> searchBST(BstNode<Integer> tree, int key) {
    // TODO - you fill in here.
//    while (tree != null) {
//      if (tree.data == key) {
//        return tree;
//      } else if (tree.data < key) {
//        tree = tree.right;
//      } else {
//        tree = tree.left;
//      }
//    }
//    return null;

    return tree == null || tree.data == key ? tree :
            tree.data> key ? searchBST(tree.left, key): searchBST(tree.right, key);
  }
  @EpiTest(testDataFile = "search_in_bst.tsv")
  public static int searchBSTWrapper(BstNode<Integer> tree, int key) {
    BstNode<Integer> result = searchBST(tree, key);
    return result != null ? result.data : -1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchInBst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
