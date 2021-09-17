package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.HashMap;

public class DoTerminatedListsOverlap {

  public static ListNode<Integer>
  overlappingNoCycleLists(ListNode<Integer> l0, ListNode<Integer> l1) {
    // TODO - you fill in here.
    // check the length of two list and forward the longer one and then traverse together
    // time : 2(M+N) Space: O(1)
//    int len0 = length(l0);
//    int len1 = length(l1);
//    if (len0 > len1)
//      for (int i = 0; i < len0- len1; i++) {
//        l0 = l0.next;
//      }
//    else {
//      for (int i = 0; i < len1- len0; i++) {
//        l1 = l1.next;
//      }
//    }
//    while (l0 != null && l1!= null && l0 != l1) {
//      l0 = l0.next;
//      l1 = l1.next;
//    }
//    return l1;


    // use hashmap to record the node been visited, time: M+N space: M/N
//    HashMap<ListNode<Integer>,Integer > dic = new HashMap<>();
//    while (l0 != null) {
//      dic.put(l0, l0.data);
//      l0 = l0.next;
//    }
//    while (l1 != null) {
//      if (dic.containsKey(l1)) {
//        return l1;
//      }
//      l1 = l1.next;
//    }
//    return null;
//
//
//
//  }

//  private static int length(ListNode<Integer> l) {
//    int ans = 0;
//    while (l != null) {
//      l = l.next;
//      ans ++;
//    }
//    return ans;
//  }



    int len0 = checkLength(l0);
    int len1 = checkLength(l1);

    if (len1 > len0) {
      l1 = advance(l1, len1, len0);
    } else {
      l0 = advance(l0, len0,len1);
    }

    while (l1!= l0 && l1 != null && l0 != null) {
      l1 = l1.next;
      l0 = l0.next;

    }
    return l1;




  }

  private static ListNode<Integer> advance(ListNode<Integer> l1, int len1, int len0) {
    while (len1- len0 > 0) {
      l1 = l1.next;
      len1--;
    }
    return l1;
  }

  private static int checkLength(ListNode<Integer> l1) {
    int length = 0;
    while (l1!= null) {
      l1 = l1.next;
      length++;
    }
    return length;

  }


  @EpiTest(testDataFile = "do_terminated_lists_overlap.tsv")
  public static void
  overlappingNoCycleListsWrapper(TimedExecutor executor, ListNode<Integer> l0,
                                 ListNode<Integer> l1, ListNode<Integer> common)
      throws Exception {
    if (common != null) {
      if (l0 != null) {
        ListNode<Integer> i = l0;
        while (i.next != null) {
          i = i.next;
        }
        i.next = common;
      } else {
        l0 = common;
      }

      if (l1 != null) {
        ListNode<Integer> i = l1;
        while (i.next != null) {
          i = i.next;
        }
        i.next = common;
      } else {
        l1 = common;
      }
    }

    final ListNode<Integer> finalL0 = l0;
    final ListNode<Integer> finalL1 = l1;
    ListNode<Integer> result =
        executor.run(() -> overlappingNoCycleLists(finalL0, finalL1));

    if (result != common) {
      throw new TestFailure("Invalid result");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DoTerminatedListsOverlap.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
