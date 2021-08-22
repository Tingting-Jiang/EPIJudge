package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.BiPredicate;
public class KLargestInHeap {
  private int value;
  private int Id;

  public KLargestInHeap(int value, int id) {
    this.value = value;
    Id = id;
  }

  private static final int CAPACITY = 16;
  @EpiTest(testDataFile = "k_largest_in_heap.tsv")
  public static List<Integer> kLargestInBinaryHeap(List<Integer> A, int k) {
    // TODO - you fill in here.
    if (k<= 0) return Collections.emptyList();


    PriorityQueue<KLargestInHeap> heap = new PriorityQueue<>(
            CAPACITY, (o1, o2) -> Integer.compare(o2.value, o1.value)
    );
    heap.add(new KLargestInHeap(A.get(0),0));

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      int idx = heap.peek().Id;
      ans.add(heap.remove().value);

      if (2*idx+1 < A.size()) heap.add(new KLargestInHeap(A.get(2*idx+1), 2*idx+1));
      if (2*idx+2 < A.size()) heap.add(new KLargestInHeap(A.get(2*idx+2), 2*idx+2));

    }

    return ans;
  }
  @EpiTestComparator
  public static boolean comp(List<Integer> expected, List<Integer> result) {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    return expected.equals(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "KLargestInHeap.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
