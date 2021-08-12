package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
public class ValidIpAddresses {
  @EpiTest(testDataFile = "valid_ip_addresses.tsv")

  public static List<String> getValidIpAddress(String s) {
    // TODO - you fill in here.

    List<String> ans = new ArrayList<>();
    for (int i = 1; i < 4 && i< s.length(); i++) {
      String first = s.substring(0,i);

      if (isValid(first)) {
        for (int j = 1; j +i <s.length() && j<4; j++) {
          String second = s.substring(i, i+j);

          if (isValid(second)){
            for (int k = 1; i+ k+j < s.length() && k<4 ; k++) {
              String third = s.substring(i+j, k+j+i);
              String fourth = s.substring(i+j+k);


              if (isValid(third) && isValid(fourth)) {
                ans.add(first+ "." + second + "." + third + "." + fourth);
              }
            }
          }
        }
      }
    }

    return ans;



  }


  private static boolean isValid(String s) {

    if (s.length() >= 4) return false;
    if (s.startsWith("0") && s.length() >1) {
      return false;
    }
    int val = Integer.parseInt(s);
    return val <= 255 && val >= 0;
  }
  @EpiTestComparator
  public static boolean comp(List<String> expected, List<String> result) {
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
            .runFromAnnotations(args, "ValidIpAddresses.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
