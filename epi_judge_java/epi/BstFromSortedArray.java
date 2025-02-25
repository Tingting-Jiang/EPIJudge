package epi;
import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TestUtils;
import epi.test_framework.TimedExecutor;

import java.util.List;
public class BstFromSortedArray {

  public static BstNode<Integer>
  buildMinHeightBSTFromSortedArray(List<Integer> A) {
    // TODO - you fill in here.
    return buildHelper(A, 0, A.size());

  }

  private static BstNode<Integer> buildHelper(List<Integer> A,  int start, int end) {
    if (start >= end) return null;
    Integer mid = start + (end - start) / 2;
    Integer root = A.get(mid);
    return new BstNode<>(root, buildHelper(A, start, mid), buildHelper(A, mid+1, end));

  }

  @EpiTest(testDataFile = "bst_from_sorted_array.tsv")
  public static int
  buildMinHeightBSTFromSortedArrayWrapper(TimedExecutor executor,
                                          List<Integer> A) throws Exception {
    BstNode<Integer> result =
        executor.run(() -> buildMinHeightBSTFromSortedArray(A));

    List<Integer> inorder = BinaryTreeUtils.generateInorder(result);

    TestUtils.assertAllValuesPresent(A, inorder);
    BinaryTreeUtils.assertTreeIsBst(result);
    return BinaryTreeUtils.binaryTreeHeight(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BstFromSortedArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
