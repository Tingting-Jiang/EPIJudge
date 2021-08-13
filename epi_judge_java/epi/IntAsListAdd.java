package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IntAsListAdd {
  @EpiTest(testDataFile = "int_as_list_add.tsv")

  public static ListNode<Integer> addTwoNumbers(ListNode<Integer> L1,
                                                ListNode<Integer> L2) {
    // TODO - you fill in here.
    ListNode<Integer> dummy = new ListNode<>(0, null);
    ListNode<Integer> node = dummy;
    int carry = 0;
    while (L1 != null || L2 != null || carry != 0) {
      carry += L1 == null ? 0 : L1.data;
      L1 = L1 == null ? L1 : L1.next;
      carry += L2 == null ? 0 : L2.data;
      L2 = L2 == null ? L2 : L2.next;
      int val =  carry % 10;
      carry /= 10;
      node.next = new ListNode<>(val, null);
      node = node.next;

    }

    return dummy.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsListAdd.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
