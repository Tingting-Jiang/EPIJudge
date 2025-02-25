package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectSortedArrays {
  @EpiTest(testDataFile = "intersect_sorted_arrays.tsv")

  public static List<Integer> intersectTwoSortedArrays(List<Integer> A,
                                                       List<Integer> B) {
    // TODO - you fill in here.
    List<Integer> ans = new ArrayList<>();
//    for (int i = 0; i < A.size(); i++) {
//      if ((i == 0 || !A.get(i).equals(A.get(i-1)))
//              && Collections.binarySearch(B, A.get(i)) >=0)  {
//        ans.add(A.get(i));
//      }
//
//    }



    int i = 0, j = 0;

    while (i < A.size() && j < B.size()) {
      if (A.get(i).equals(B.get(j)) &&(i == 0 || !A.get(i).equals(A.get(i-1)))) {
        ans.add(A.get(i));
        i++;
        j++;
      }
      else if (A.get(i) < B.get(j)) {
        i++;
      } else {
        j++;
      }

    }


    return ans;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntersectSortedArrays.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
