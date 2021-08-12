package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseSublist {
  @EpiTest(testDataFile = "reverse_sublist.tsv")

  public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start,
                                                 int finish) {
    // TODO - you fill in here.
    if (L == null) return null;
    ListNode<Integer> dummy = new ListNode<>(0, L);
    ListNode<Integer> prev = dummy;
    int traverse = 0;
    while (traverse < start-1) {
      prev = prev.next;
      traverse ++;
    }

    ListNode<Integer> curr = prev.next;
    ListNode<Integer> suc = curr.next;
   for (int i = 0; i< finish - start; i++) {
      curr.next = suc.next;
      suc.next = prev.next;
      prev.next = suc;
      suc = curr.next;
    }
    return dummy.next;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseSublist.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
