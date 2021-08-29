package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class SortList {
  @EpiTest(testDataFile = "sort_list.tsv")

  public static ListNode<Integer> stableSortList(ListNode<Integer> L) {
    // TODO - you fill in here.

    if (L== null || L.next == null) return L;
    ListNode<Integer> preSlow = null, slow = L, fast = L;
    while (fast != null && fast.next != null) {
      preSlow = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    if (preSlow!= null) {
      preSlow.next = null;
    }

    return SortedListsMerge.mergeTwoSortedLists(stableSortList(L), stableSortList(slow));
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
