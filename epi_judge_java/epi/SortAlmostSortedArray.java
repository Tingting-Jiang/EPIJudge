package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAlmostSortedArray {

  public static List<Integer>
  sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
    // TODO - you fill in here.
    PriorityQueue<Integer> heap = new PriorityQueue<>();

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < k+1 && sequence.hasNext(); i++) {
      heap.add(sequence.next());

    }
    while (sequence.hasNext()) {
      Integer smallest = heap.remove();
      ans.add(smallest);
      heap.add(sequence.next());
    }
//    ans.addAll(Stream.generate(heap::remove).limit(heap.size()).collect(Collectors.toList()));
    while (!heap.isEmpty()) {
      ans.add(heap.remove());
    }

    return ans;
  }
  @EpiTest(testDataFile = "sort_almost_sorted_array.tsv")
  public static List<Integer>
  sortApproximatelySortedDataWrapper(List<Integer> sequence, int k) {
    return sortApproximatelySortedData(sequence.iterator(), k);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortAlmostSortedArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
