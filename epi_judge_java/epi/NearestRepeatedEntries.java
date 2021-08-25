package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.List;
public class NearestRepeatedEntries {
  @EpiTest(testDataFile = "nearest_repeated_entries.tsv")

  public static int findNearestRepetition(List<String> paragraph) {
    // TODO - you fill in here.
    int dif = Integer.MAX_VALUE;
    HashMap<String, Integer> dic = new HashMap<>();
    for( int i = 0; i <paragraph.size();i++) {
      if (dic.containsKey(paragraph.get(i))) {
        dif = Math.min(dif, i- dic.get(paragraph.get(i)));
      }
      dic.put(paragraph.get(i),i);
    }


    return dif == Integer.MAX_VALUE ? -1 : dif;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NearestRepeatedEntries.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
