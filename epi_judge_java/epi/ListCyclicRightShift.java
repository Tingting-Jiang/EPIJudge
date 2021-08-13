package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ListCyclicRightShift {
  @EpiTest(testDataFile = "list_cyclic_right_shift.tsv")

  public static ListNode<Integer> cyclicallyRightShiftList(ListNode<Integer> L,
                                                           int k) {
    // TODO - you fill in here.
    if (L == null) return null;
    ListNode<Integer> tail = L;
    int length = 1;
    while (tail.next != null) {
      tail = tail.next;
      length++;
    }

    k %= length;
    if (k == 0) return L;
    tail.next = L;

    for (int i = 0; i < length - k; i++) {
      tail = tail.next;
    }
    ListNode<Integer> head = tail.next;
    tail.next = null;
    return head;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ListCyclicRightShift.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
