package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;

import java.util.List;
public class SearchForMinMaxInArray {
  @EpiUserType(ctorParams = {Integer.class, Integer.class})

  public static class MinMax {
    public Integer smallest;
    public Integer largest;

    public MinMax(Integer smallest, Integer largest) {
      this.smallest = smallest;
      this.largest = largest;
    }

    private static MinMax minMax(Integer a, Integer b) {
      return Integer.compare(b, a) < 0 ? new MinMax(b, a) : new MinMax(a, b);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      MinMax minMax = (MinMax)o;

      if (!smallest.equals(minMax.smallest)) {
        return false;
      }
      return largest.equals(minMax.largest);
    }

    @Override
    public String toString() {
      return "min: " + smallest + ", max: " + largest;
    }
  }

  @EpiTest(testDataFile = "search_for_min_max_in_array.tsv")

  public static MinMax findMinMax(List<Integer> A) {
    // TODO - you fill in here.
    if (A.size()<=1) return new MinMax(A.get(0), A.get(0));
//    int small = A.get(0) < A.get(1)? A.get(0): A.get(1);
//    int large = small == A.get(0)? A.get(1) : A.get(0);
//
//    MinMax global = new MinMax(small, large);
    MinMax global = MinMax.minMax(A.get(0), A.get(1));
    for (int i = 2; i + 1 < A.size(); i+=2) {

//      MinMax local = new MinMax(Math.min(A.get(i), A.get(i+1)), Math.max(A.get(i), A.get(i+1)));
//      global = new MinMax(Math.min(global.smallest, local.smallest), Math.max(global.largest, local.largest));
      MinMax local = MinMax.minMax(A.get(i), A.get(i+1));
      global = new MinMax(Math.min(global.smallest, local.smallest),
              Math.max(global.largest, local.largest));

    }
    if (A.size() % 2 != 0) {
      global = new MinMax(Math.min(global.smallest, A.get(A.size()-1)),
              Math.max(global.largest, A.get(A.size()-1)));

    }



    return global;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchForMinMaxInArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
