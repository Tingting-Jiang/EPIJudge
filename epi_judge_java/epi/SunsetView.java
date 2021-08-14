package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;
import java.util.stream.Collectors;

public class SunsetView {
  private int id;
  private int height;

  public SunsetView(int id, int height) {
    this.height = height;
    this.id = id;
  }

  public static List<Integer>
  examineBuildingsWithSunset(Iterator<Integer> sequence) {
    // TODO - you fill in here.

    Deque<SunsetView> stack = new ArrayDeque<>();
    List<Integer> ans = new ArrayList<>();
    int buildingId = 0;

    while (sequence.hasNext()) {
      int height = sequence.next();
      while (!stack.isEmpty() && height >= stack.peekFirst().height) {
        stack.removeFirst();
      }
      stack.addFirst(new SunsetView(buildingId++, height));

    }
    while (!stack.isEmpty()) {
      ans.add(stack.removeFirst().id);
    }
    return ans;

    // the above four lines can be replaced by the following one
//    return stack.stream().map(c->c.id).collect(Collectors.toList());






  }
  @EpiTest(testDataFile = "sunset_view.tsv")
  public static List<Integer>
  examineBuildingsWithSunsetWrapper(List<Integer> sequence) {
    return examineBuildingsWithSunset(sequence.iterator());
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SunsetView.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
