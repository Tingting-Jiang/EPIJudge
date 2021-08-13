package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class IsListPalindromic {
  @EpiTest(testDataFile = "is_list_palindromic.tsv")

  public static boolean isLinkedListAPalindrome(ListNode<Integer> L) {
    // TODO - you fill in here.

    ListNode<Integer> slow = L;
    ListNode<Integer> fast = L;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode<Integer> start = L;
    ListNode<Integer> half = reverse(slow);

    while (half != null && start != null) {
//      if (start.data != half.data) {
      if (!(start.data.equals(half.data))) {
        return false; // here must use equals to pass all tests
      }
      start = start.next;
      half = half.next;
    }

    return true;

  }

  private static ListNode<Integer> reverse(ListNode<Integer> head) {
    ListNode<Integer> prev = null;
    ListNode<Integer> curr = head;
    while (curr != null) {
      ListNode<Integer> succ = curr.next;
      curr.next  = prev;
      prev = curr;
      curr = succ;
    }
    return prev;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsListPalindromic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
