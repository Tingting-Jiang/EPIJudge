package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
public class PhoneNumberMnemonic {
  @EpiTest(testDataFile = "phone_number_mnemonic.tsv")

  public static List<String> phoneMnemonic(String phoneNumber) {
    // TODO - you fill in here.

    List<String> ans = new ArrayList<>();
    helper(phoneNumber, 0, new char[phoneNumber.length()], ans);

    return ans;
  }
  private static final String[] MAP = {"0","1","ABC","DEF", "GHI", "JKL","MNO", "PQRS","TUV", "WXYZ"};

  private static void helper(String phoneNumber, int digit, char[] chars, List<String> ans) {
    if (phoneNumber.length() == digit) {
      ans.add(new String(chars));
    }
    else {
      for (int i = 0; i < MAP[phoneNumber.charAt(digit) - '0'].length(); i++) {
        char c = MAP[phoneNumber.charAt(digit) - '0'].charAt(i);
        chars[digit] = c;
        helper(phoneNumber, digit+1, chars, ans);
      }
    }
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
            .runFromAnnotations(args, "PhoneNumberMnemonic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
