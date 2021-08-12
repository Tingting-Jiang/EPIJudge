package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
  @EpiTest(testDataFile = "roman_to_integer.tsv")

  public static int romanToInteger(String s) {
    // TODO - you fill in here.
//    HashMap<Character, Integer> dic = new HashMap<>();
//    dic.put('I', 1);
//    dic.put('V', 5);
//    dic.put('X', 10);
//    dic.put('L', 50);
//    dic.put('C', 100);
//    dic.put('D', 500);
//    dic.put('M', 1000);

    Map<Character, Integer> dic= Map.of(
           'I', 1, 'V',5, 'X', 10,
            'L',50,'C', 100, 'D', 500,
    'M',1000);


    int ans = dic.get(s.charAt(s.length() -1));
    for (int i = s.length() -2; i >= 0; --i) {
      if (dic.get(s.charAt(i)) < dic.get(s.charAt(i+1))) {
        ans -= dic.get(s.charAt(i));
      }
      else{
        ans += dic.get(s.charAt(i));
      }
    }
    return ans;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RomanToInteger.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
