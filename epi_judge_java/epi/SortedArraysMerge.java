package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortedArraysMerge {
  private int value;
  private int arrayId;

  public SortedArraysMerge(int value, int arrayId) {
    this.value = value;
    this.arrayId = arrayId;
  }

  @EpiTest(testDataFile = "sorted_arrays_merge.tsv")

  public static List<Integer>
  mergeSortedArrays(List<List<Integer>> sortedArrays) {
    // TODO - you fill in here.

    // initiate heap
    PriorityQueue<SortedArraysMerge> heap = new PriorityQueue<>(
            sortedArrays.size(), (o1, o2) -> Integer.compare(o1.value, o2.value));

    List<Iterator<Integer>> iters = new ArrayList<>();
    for (List<Integer> array: sortedArrays) {
      iters.add(array.iterator());
    }


    for (int i = 0; i < iters.size(); i++) {
      if (iters.get(i).hasNext()) {
        heap.add(new SortedArraysMerge(iters.get(i).next(), i));
      }
    }

    List<Integer> ans = new ArrayList<>();
    while (!heap.isEmpty()) {
      SortedArraysMerge pair = heap.poll();
      ans.add(pair.value);
      // add number from the same array ID
      if (iters.get(pair.arrayId).hasNext()) {
        heap.add(new SortedArraysMerge(iters.get(pair.arrayId).next(), pair.arrayId));
      }
    }

    return ans;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedArraysMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
