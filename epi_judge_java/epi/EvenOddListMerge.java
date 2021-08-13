package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Arrays;
import java.util.List;
public class EvenOddListMerge {
  @EpiTest(testDataFile = "even_odd_list_merge.tsv")

  public static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
    // TODO - you fill in here.

    ListNode<Integer> oddList = new ListNode<>(0, null);
    ListNode<Integer> evenList = new ListNode<>(0, null);
    List<ListNode<Integer>> merge = Arrays.asList(evenList, oddList);

    int turn = 0;
    while (L != null) {
      merge.get(turn).next = L;
      merge.set(turn, merge.get(turn).next);
      L = L.next;
      turn ^= 1;

    }
    merge.get(1).next = null;
    merge.get(0).next = oddList.next;
    return evenList.next;
  }
  // time : O(N) space: O(1)

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EvenOddListMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
