package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsStringPalindromic {
  @EpiTest(testDataFile = "is_string_palindromic.tsv")

  public static boolean isPalindromic(String s) {
    // TODO - you fill in here.
//    int left= 0;
//    int right = s.length() -1;
//    while (left < right) {
//      if (s.charAt(left) != s.charAt(right)) {
//        return false;
//      }
//      else {
//        left ++;
//        right --;
//      }
//    }
//



    // more concise version:
    for(int left = 0, right = s.length() -1; left< right; left ++, right--) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }

    }
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsStringPalindromic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
