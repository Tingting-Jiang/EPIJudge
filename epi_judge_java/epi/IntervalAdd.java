package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class IntervalAdd {
  @EpiUserType(ctorParams = {int.class, int.class})

  public static class Interval {
    public int left, right;

    public Interval(int l, int r) {
      this.left = l;
      this.right = r;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Interval interval = (Interval)o;

      if (left != interval.left) {
        return false;
      }
      return right == interval.right;
    }

    @Override
    public String toString() {
      return "[" + left + ", " + right + "]";
    }
  }

  @EpiTest(testDataFile = "interval_add.tsv")

  public static List<Interval> addInterval(List<Interval> disjointIntervals,
                                           Interval newInterval) {
    // TODO - you fill in here.
    List<Interval> ans = new ArrayList<>();

    int idx = 0;
    while (idx < disjointIntervals.size() && disjointIntervals.get(idx).right < newInterval.left) {
        ans.add(disjointIntervals.get(idx));
        idx ++;
      }

    while (idx < disjointIntervals.size() && disjointIntervals.get(idx).left <= newInterval.right) {
        newInterval = new Interval(Math.min(disjointIntervals.get(idx).left, newInterval.left),
                Math.max(disjointIntervals.get(idx).right, newInterval.right));
        idx ++;
    }

    ans.add(newInterval);
    ans.addAll(disjointIntervals.subList(idx, disjointIntervals.size()));


    return ans;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntervalAdd.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
