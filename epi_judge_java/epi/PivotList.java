package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.LongUnaryOperator;

public class PivotList {

  public static ListNode<Integer> listPivoting(ListNode<Integer> l, int x) {
    // TODO - you fill in here.

    ListNode<Integer> lessHead = new ListNode<>(0, null);
    ListNode<Integer> equalHead = new ListNode<>(0, null);
    ListNode<Integer> moreHead = new ListNode<>(0, null);
    List<ListNode<Integer>> merge = Arrays.asList(lessHead, equalHead, moreHead);
//    ListNode<Integer> curr = l, less = lessHead, equal= equalHead, more = moreHead;

//    while (curr!= null) {
//      if (curr.data < x) {
//        less.next = curr;
//        less = curr;
//
//      }
//      else if (curr.data == x) {
//        equal.next = curr;
//        equal = curr;
//      }
//      else {
//        more.next = curr;
//        more = curr;
//      }
//      curr = curr.next;
//    }
//
//    more.next = null;
//    equal.next = moreHead.next;
//    less.next = equalHead.next;

    ListNode<Integer> curr = l;
    while (curr != null) {
      if (curr.data < x) {
        merge.get(0).next = curr;
        merge.set(0, curr);
      }
      else if (curr.data == x) {
        merge.get(1).next = curr;
        merge.set(1, curr);
      }
      else {
        merge.get(2).next = curr;
        merge.set(2, curr);
      }
      curr = curr.next;
    }
    merge.get(2).next = null;
    merge.get(1).next = moreHead.next;
    merge.get(0).next = equalHead.next;

    return lessHead.next;


  }
  public static List<Integer> linkedToList(ListNode<Integer> l) {
    List<Integer> v = new ArrayList<>();
    while (l != null) {
      v.add(l.data);
      l = l.next;
    }
    return v;
  }

  @EpiTest(testDataFile = "pivot_list.tsv")
  public static void listPivotingWrapper(TimedExecutor executor,
                                         ListNode<Integer> l, int x)
      throws Exception {
    List<Integer> original = linkedToList(l);

    final ListNode<Integer> finalL = l;
    l = executor.run(() -> listPivoting(finalL, x));

    List<Integer> pivoted = linkedToList(l);

    int mode = -1;
    for (Integer i : pivoted) {
      switch (mode) {
      case -1:
        if (i == x) {
          mode = 0;
        } else if (i > x) {
          mode = 1;
        }
        break;
      case 0:
        if (i < x) {
          throw new TestFailure("List is not pivoted");
        } else if (i > x) {
          mode = 1;
        }
        break;
      case 1:
        if (i <= x) {
          throw new TestFailure("List is not pivoted");
        }
      }
    }

    Collections.sort(original);
    Collections.sort(pivoted);
    if (!original.equals(pivoted))
      throw new TestFailure("Result list contains different values");
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PivotList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
