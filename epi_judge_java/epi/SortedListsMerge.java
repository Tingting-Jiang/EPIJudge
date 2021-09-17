package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SortedListsMerge {
  @EpiTest(testDataFile = "sorted_lists_merge.tsv")
  //@include
  public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                      ListNode<Integer> L2) {
    // TODO - you fill in here.
    ListNode<Integer> dummy = new ListNode<>(0,null);
    ListNode<Integer> traverse = dummy;
    while (L1 != null && L2!= null) {
      if(L1.data < L2.data) {
        traverse.next = L1;
        L1 = L1.next;
      } else {
        traverse.next = L2;
        L2 = L2.next;
      }
      traverse = traverse.next;
    }
    traverse.next = L1 == null ? L2 : L1;
    return dummy.next;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
