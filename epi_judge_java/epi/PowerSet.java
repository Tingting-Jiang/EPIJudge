package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;
import epi.test_framework.LexicographicalListComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class PowerSet {
  @EpiTest(testDataFile = "power_set.tsv")

  public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
    // TODO - you fill in here.
    List<List<Integer>> ans = new ArrayList<>();
//    System.out.println("new test + " + inputSet + "----------");

    helper(inputSet, new ArrayList<Integer>(), ans);

    return ans;
  }

  private static void helper(List<Integer> inputSet, ArrayList<Integer> path, List<List<Integer>> ans) {

    ans.add(new ArrayList<>(path));
//    System.out.println("ans" + ans);
    for (int i = 0; i < inputSet.size(); i++) {
      System.out.println(inputSet + " " + i + " " + path );
      path.add(inputSet.get(i));
//      System.out.println(inputSet + " " + i + " " + path );
//      System.out.println("sublist: " +inputSet.subList(i + 1, inputSet.size()));
        helper(inputSet.subList(i + 1, inputSet.size()), path, ans);
        path.remove(path.size()-1);
//      System.out.println("after remove: " + path);


    }
  }

  @EpiTestComparator
  public static boolean comp(List<List<Integer>> expected,
                             List<List<Integer>> result) {
    if (result == null) {
      return false;
    }
    for (List<Integer> l : expected) {
      Collections.sort(l);
    }
    expected.sort(new LexicographicalListComparator<>());
    for (List<Integer> l : result) {
      Collections.sort(l);
    }
    result.sort(new LexicographicalListComparator<>());
    return expected.equals(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PowerSet.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
