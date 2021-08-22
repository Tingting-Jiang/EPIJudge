package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class OnlineMedian {
  private static final int CAPACITY = 16;
  public static List<Double> onlineMedian(Iterator<Integer> sequence) {
    // TODO - you fill in here.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(CAPACITY, Collections.reverseOrder());
    List<Double> ans = new ArrayList<>();

    while (sequence.hasNext()) {
      int num = sequence.next();
      minHeap.add(num);
      maxHeap.add(minHeap.remove());
      if (maxHeap.size() > minHeap.size()) {
        minHeap.add(maxHeap.remove());
      }
      ans.add(minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) * 0.5 : minHeap.peek());


      }


    return ans;
  }
  @EpiTest(testDataFile = "online_median.tsv")
  public static List<Double> onlineMedianWrapper(List<Integer> sequence) {
    return onlineMedian(sequence.iterator());
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "OnlineMedian.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
